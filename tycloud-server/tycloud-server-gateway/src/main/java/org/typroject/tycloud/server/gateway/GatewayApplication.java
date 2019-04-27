package org.typroject.tycloud.server.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by magintursh on 2017-05-03.
 */

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).run(args);
    }
}