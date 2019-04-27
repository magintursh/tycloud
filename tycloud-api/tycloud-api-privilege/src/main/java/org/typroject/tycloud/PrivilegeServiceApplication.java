package org.typroject.tycloud;

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
@MapperScan("org.tycloud.*.*.face.orm.dao")
@SpringBootApplication
public class PrivilegeServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PrivilegeServiceApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
