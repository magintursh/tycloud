package org.typroject.tycloud.server.config.admin.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.typroject.tycloud.server.config.admin.core.domain.Env;
import org.typroject.tycloud.server.config.admin.core.service.impl.BaseUrlMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 程序猿DD/翟永超 on 2018/4/24.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Slf4j
public class UrlMaker4Eureka extends BaseUrlMaker {

    /**
     * eureka的rest接口：根据服务名称获取实例清单
     */
    private String getInstantsUrl = "/apps/{serviceName}";
//    private String getInstantsUrl = "/eureka/apps/{serviceName}";


    @Override
    public String configServerBaseUrl(String envName) {
        Env env = envRepo.findByName(envName);

        if (env.getRegistryAddress() == null || env.getRegistryAddress().isEmpty()) {
            // 如果没有配置注册中心，直接取服务名字段（配置中心访问地址）
            return super.configServerBaseUrl(envName);
        }

        // 优化访问eureka的url处理
        String url = env.getRegistryAddress() + getInstantsUrl.replace("{serviceName}", env.getConfigServerName());
        url = url.replaceAll("//", "/").replaceFirst(":/", "://");

        log.info("Get config server instances url : " + url);

        // 访问eureka接口获取一个可以访问的实例
        RestTemplate restTemplate = newRestTemplateInstance(url);
        String rStr = restTemplate.getForObject(url, String.class);
        JSONObject response = JSON.parseObject(rStr);

        String homePageUrl = null;

        for (Object o : response.getJSONObject("application").getJSONArray("instance")) {
            Map<String, String> instance = (Map) o;
            if (instance.get("status").equals("UP")) {
                homePageUrl = instance.get("homePageUrl");
            }
        }

        if (homePageUrl == null) {
            // 没有可用的config server
            throw new RuntimeException("No instances : " + env.getConfigServerName());
        }

        if(homePageUrl.lastIndexOf("/") + 1 == homePageUrl.length() &&
                env.getContextPath() != null && env.getContextPath().indexOf("/") == 0) {
            homePageUrl = homePageUrl.substring(0, homePageUrl.length() - 1);
        }

        return homePageUrl + env.getContextPath();
    }

    @Override
    public List<String> allConfigServerBaseUrl(String envName) {
        List<String> result = new ArrayList<>();

        Env env = envRepo.findByName(envName);

        if (env.getRegistryAddress() == null || env.getRegistryAddress().isEmpty()) {
            // 如果没有配置注册中心，直接取服务名字段（配置中心访问地址）
            result.add(env.getConfigServerName() + env.getContextPath());
            return result;
        }

        // 优化访问eureka的url处理
        String url = env.getRegistryAddress() + getInstantsUrl.replace("{serviceName}", env.getConfigServerName());
        url = url.replaceAll("//", "/").replaceFirst(":/", "://");

        log.info("Get config server instances url : " + url);

        RestTemplate restTemplate = newRestTemplateInstance(url);
        // 访问eureka接口获取一个可以访问的实例
        String rStr = restTemplate.getForObject(url, String.class);
        JSONObject response = JSON.parseObject(rStr);

        for (Object o : response.getJSONObject("application").getJSONArray("instance")) {
            Map<String, String> instance = (Map) o;
            if (instance.get("status").equals("UP")) {
                String homePageUrl = instance.get("homePageUrl");
                if(homePageUrl.lastIndexOf("/") + 1 == homePageUrl.length()
                        && env.getContextPath() != null && env.getContextPath().indexOf("/") == 0) {
                    homePageUrl = homePageUrl.substring(0, homePageUrl.length() - 1);
                }
                result.add(homePageUrl + env.getContextPath());
            }
        }

        return result;
    }

    /***
     * new RestTemplate instance for requesting Eureka server
     * @param url
     * @return  RestTemplate  instance
     */
    private RestTemplate newRestTemplateInstance(String url) {
        RestTemplate restTemplate = new RestTemplate();
        boolean isIncludedBasicAuth = url.contains("@");
        if (isIncludedBasicAuth) {
            String userNamePasswordString = url.substring(url.indexOf("://")+3, url.indexOf("@"));
            String[] userNameAndPasswordArray = userNamePasswordString.split(":");
            String userName = userNameAndPasswordArray[0];
            String password = userNameAndPasswordArray[1];
            restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(userName, password));
        }
        return restTemplate;
    }

}
