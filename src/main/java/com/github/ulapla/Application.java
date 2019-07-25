package com.github.ulapla;

import com.github.ulapla.storage.StorageProperties;
import com.github.ulapla.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



//    @Bean
//    public Docket newsApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//               // .groupName("Book API")
//                //.apiInfo(apiInfo())
//                .select()
//                .paths(regex("/api.*"))
//                .build();
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .description("Simple REST API to learn")
//                .title("Collected items")
//                .build();
//    }

}
