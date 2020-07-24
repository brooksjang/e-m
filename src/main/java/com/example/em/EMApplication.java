package com.example.em;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.em.dao")
@SpringBootApplication
public class EMApplication {

    public static void main(String[] args) {
        SpringApplication.run(EMApplication.class, args);
    }

}
