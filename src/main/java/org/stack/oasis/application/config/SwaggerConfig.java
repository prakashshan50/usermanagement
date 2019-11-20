package org.stack.oasis.application.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
*
* @author Prakash Nagaraj
* @version 1.0 
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {   
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()   
           .apis(RequestHandlerSelectors.basePackage("org.stack.oasis.application.controllers"))
//          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build().apiInfo(apiInfo());                                           
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "User Management API Details", 
          "System and organization administrators use a combination of user logins, privileges, permissions, and roles (role-based access control) to manage Data Director users. Role-based access control provides management of users and the tasks that they can perform on objects.", 
          "API TOS", 
          "Terms of service", 
          new Contact("© Stack Oasis", "www.example.com", "prakash.gmail.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }

}
