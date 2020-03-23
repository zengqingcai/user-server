package com.user.general;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Authod:zeng
 * @Date: 2020/3/3 10:18
 * @Version: 0.0.1
 */
@SpringBootApplication(scanBasePackages = "com.user.general")
@EnableCaching(proxyTargetClass = true) // 开启缓存功能
@EnableAsync
@MapperScan("com.user.general.**.dao")
@EnableFeignClients(basePackages = "com.user.general")
@SpringCloudApplication
public class UserGeneralApplication extends SpringBootServletInitializer implements CommandLineRunner {
    // 入口
    public static void main(String[] args) {
        SpringApplication.run(UserGeneralApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("springboot启动完成！");
    }


}