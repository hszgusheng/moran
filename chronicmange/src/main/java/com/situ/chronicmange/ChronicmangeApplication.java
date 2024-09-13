package com.situ.chronicmange;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.situ.chronicmange.mapper")
public class ChronicmangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChronicmangeApplication.class, args);
    }

}
