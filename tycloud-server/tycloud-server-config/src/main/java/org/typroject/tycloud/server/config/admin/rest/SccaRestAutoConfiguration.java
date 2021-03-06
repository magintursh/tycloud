package org.typroject.tycloud.server.config.admin.rest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.typroject.tycloud.server.config.admin.rest.config.SccaErrorAttributes;

/**
 * Created by 程序猿DD/翟永超 on 2018/6/23.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@ComponentScan
@Configuration
@EnableConfigurationProperties(SccaRestProperties.class)
@PropertySource("scca-rest.properties")
@EntityScan("org.typroject.tycloud.server.config.admin.rest.domain")
@EnableJpaRepositories(basePackages = "org.typroject.tycloud.server.config.admin.rest.domain")
public class SccaRestAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ErrorAttributes errorAttributes() {
        return new SccaErrorAttributes();
    }

    @Bean
    @ConditionalOnMissingBean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
