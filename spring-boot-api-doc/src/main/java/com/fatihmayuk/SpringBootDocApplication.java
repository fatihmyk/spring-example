package com.fatihmayuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableSwagger2
public class SpringBootDocApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDocApplication.class,args);

    }
}
