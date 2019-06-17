package org.typroject.tycloud.server.config.admin.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("scca.rest")
public class SccaRestProperties {

    /**
     * scca-rest¬的contextPath
     */
    private String contextPath = "";

}
