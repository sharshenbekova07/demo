package com.example.demo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebConfiguration {

    @Bean
    public OpenAPI swaggerConfig(){
        Info info=new Info();
        info
                .title("my_telegram")
                .description("Практический проект по разработке mini_telegram")
                .version("0.0.1 SNAPSHOT"
                );
        return new OpenAPI().info(info);
    }
}
