package org.typroject.tycloud.api.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.typroject.tyboot.core.restful.interceptor.MyWebAppConfigurer;

@Configuration
public class MvcConfig extends MyWebAppConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login"); //自定义的登陆页面
        registry.addViewController("/oauth/confirm_access").setViewName("oauth_approval"); //自定义的授权页面
    }
}