package com.xavi.EmployeeMicroservice.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Sunday 21/08/2022
 **/

@Configuration
@EnableWebMvc
public class SwaggerConfiguration implements WebMvcConfigurer {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xavi.EmployeeMicroservice"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    /**
     *  Describe the swagger ui
     * @return apiInfo()
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot Employee Microservice REST Application with CRUD operations")
                .description("Documentation for Employee Microservice REST Endpoints in Spring Boot + MySQL + HATEOAS" +
                        "  " + " RabbitMQ + Tests").version("1.0")
                .contact(new Contact("Author: Xavier Francis", " https://github.com/Xavier-Frank", "oduorfrancis134" +
                        "@gmail.com"))
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars");
    }
}
