package com.example.poster_final_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.TimeZone;

@SpringBootApplication()
@EnableJpaRepositories("com.example.poster_final_project.dao.repositories")
@EnableTransactionManagement
public class PosterFinalProjectApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(PosterFinalProjectApplication.class, args);
    }



}
