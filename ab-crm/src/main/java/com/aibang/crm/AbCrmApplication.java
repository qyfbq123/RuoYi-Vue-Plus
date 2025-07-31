package com.aibang.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication(scanBasePackages = {
        "com.aibang.crm",
        "org.dromara"
})
public class AbCrmApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AbCrmApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("AiBangCRM启动成功!");
    }

}
