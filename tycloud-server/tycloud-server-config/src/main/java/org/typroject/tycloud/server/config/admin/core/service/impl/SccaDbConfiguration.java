package org.typroject.tycloud.server.config.admin.core.service.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.typroject.tycloud.server.config.admin.core.service.PersistenceService;

/**
 * Created by 程序猿DD/翟永超 on 2018/5/2.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Configuration
@PropertySource("scca-persistence-db.properties")
public class SccaDbConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public PersistenceService persistenceService() {
        return new DbPersistenceService();
    }

}
