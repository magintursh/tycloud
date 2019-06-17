package org.typroject.tycloud.server.config.admin.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.typroject.tycloud.server.config.admin.core.service.UrlMakerService;

/**
 * Created by 程序猿DD/翟永超 on 2018/5/2.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Configuration
public class SccaEurekaConfiguration {

    @Bean
    public UrlMakerService urlMakerService() {
        return new UrlMaker4Eureka();
    }

}
