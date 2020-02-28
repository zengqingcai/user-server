package com.user.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.user.account")
@EnableCaching(proxyTargetClass = true) // 开启缓存功能
@EnableAsync
@MapperScan("com.user.account.**.dao")
@EnableFeignClients(basePackages = "com.user.**.remote")
@SpringCloudApplication
//@EnableScanTopic
//@EnableScheduling
public class UserAccountApplication extends SpringBootServletInitializer implements CommandLineRunner {
    // 入口
    public static void main(String[] args) {
        SpringApplication.run(UserAccountApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("springboot启动完成！");
    }
    

}