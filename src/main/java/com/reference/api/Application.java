package com.reference.api;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
   @Bean
   public Docket personApi() {
       return new Docket(DocumentationType.SWAGGER_2)
               .groupName("spring-swagger-api-1")
               .apiInfo(apiInfo())
               .select()
               .paths(regex ("/people.*"))
               .build();
   }
   @Bean
   public Docket employeeApi() {
       return new Docket(DocumentationType.SWAGGER_2)
               .groupName("spring-swagger-api-2")
               .apiInfo(apiInfo())
               .select()
               .paths(regex ("/employee.*"))
               .build();
   }
    
   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("Spring REST Sample with Swagger")
               .description("Spring REST Sample with Swagger")
               .license("Apache License Version 2.0")
               .licenseUrl("https://github.com/singh4java")
               .version("1.0")
               .build();
   }


}
