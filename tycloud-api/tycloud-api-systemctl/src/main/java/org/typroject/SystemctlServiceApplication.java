package org.typroject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by magintursh on 2017-05-03.
 */
@EnableAsync(proxyTargetClass = true)
@MapperScan(value = {"org.typroject.tyboot.*.*.face.orm.dao","org.typroject.tycloud.*.*.face.orm.dao"})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class SystemctlServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SystemctlServiceApplication.class).web(true).run(args);
    }
}
