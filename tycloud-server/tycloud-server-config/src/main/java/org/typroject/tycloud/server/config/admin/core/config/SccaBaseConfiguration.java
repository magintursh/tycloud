package org.typroject.tycloud.server.config.admin.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.typroject.tycloud.server.config.admin.core.service.BaseOptService;
import org.typroject.tycloud.server.config.admin.core.service.PropertiesService;
import org.typroject.tycloud.server.config.admin.core.service.UrlMakerService;
import org.typroject.tycloud.server.config.admin.core.service.impl.BaseOptServiceImpl;
import org.typroject.tycloud.server.config.admin.core.service.impl.BaseUrlMaker;
import org.typroject.tycloud.server.config.admin.core.service.impl.PropertiesServiceImpl;

/**
 * Created by 程序猿DD/翟永超 on 2018/5/2.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Configuration
@EnableConfigurationProperties({SccaProperties.class, SccaConfigServerProperties.class})
@EntityScan("org.typroject.tycloud.server.config.admin.core.domain")
@EnableJpaRepositories(basePackages = "org.typroject.tycloud.server.config.admin.core.domain")
public class SccaBaseConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public BaseOptService optService() {
        return new BaseOptServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public PropertiesService propertiesService() {
        return new PropertiesServiceImpl();
    }

    /**
     * 不使用基于服务的配置中心配置
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnMissingClass({
            "org.typroject.tycloud.server.config.admin.rest.UrlMaker4Eureka"
    })
    public UrlMakerService urlMakerService() {
        return new BaseUrlMaker();
    }

}
