package org.typroject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by magintursh on 2017-05-03.
 */
//@actuator

@EnableEurekaClient
@MapperScan(value = {"org.typroject.tyboot.*.*.face.orm.dao","org.typroject.tycloud.*.*.face.orm.dao"})
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
