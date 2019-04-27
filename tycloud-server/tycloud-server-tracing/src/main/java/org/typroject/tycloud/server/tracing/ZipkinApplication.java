package org.typroject.tycloud.server.tracing;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * Created by magintursh on 2017-05-03.
 */
@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class ZipkinApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZipkinApplication.class).run(args);
    }
}