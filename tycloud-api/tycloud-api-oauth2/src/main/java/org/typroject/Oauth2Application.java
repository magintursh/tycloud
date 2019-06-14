package org.typroject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by magintursh on 2017-05-03.
 */
//@actuator
@MapperScan(value = {"org.typroject.tyboot.*.*.face.orm.dao","org.typroject.tycloud.*.*.face.orm.dao"})
@SpringBootApplication
public class Oauth2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Oauth2Application.class).web(WebApplicationType.SERVLET).run(args);
    }
}
