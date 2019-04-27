package org.typroject.tycloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by magintursh on 2017-05-03.
 */
@EnableAsync(proxyTargetClass = true)
@MapperScan({"org.tycloud.*.*.face.orm.dao"})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class SystemctlServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SystemctlServiceApplication.class).web(true).run(args);
    }
}
