package com.web.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

   @Bean
   public Docket createRestApi() {
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .select()
               //扫描指定包中的swagger注解
               //扫描所有有注解的api，用这种方式更灵活
               .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
               .paths(PathSelectors.any())
               .build();
   }

   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("小黄狗-BOSS-api")
               .description("boss")
               .termsOfServiceUrl("")
               .version("1.0")
               .build();
   }
	
    
    
  
}