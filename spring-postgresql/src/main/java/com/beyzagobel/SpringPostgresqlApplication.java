package com.beyzagobel;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPostgresqlApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    // Swagger Bean
    @Bean
    public OpenAPI customopenAPI(@Value("${application-description}") String description,
                                 @Value("${application-version}") String version){
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Examples API")
                        .version(version)
                        .description(description)
                        .license(new License().name("Spring Example API Lisence")));
    }

}
