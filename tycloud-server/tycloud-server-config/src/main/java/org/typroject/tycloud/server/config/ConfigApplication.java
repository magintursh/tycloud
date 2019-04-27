package org.typroject.tycloud.server.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by magintursh on 2017-05-03.
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigApplication.class).run(args);
    }
}