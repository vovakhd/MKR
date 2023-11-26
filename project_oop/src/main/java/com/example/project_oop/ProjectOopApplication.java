package com.example.project_oop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ProjectOopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectOopApplication.class, args);
    }
}

