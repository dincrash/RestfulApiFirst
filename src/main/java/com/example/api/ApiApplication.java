package com.example.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.hello")
@EnableJpaRepositories("com.jpaRepository")
@EntityScan("com.entity")
public class ApiApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }


    @Override
    public void run(String... args) {


    }

}
