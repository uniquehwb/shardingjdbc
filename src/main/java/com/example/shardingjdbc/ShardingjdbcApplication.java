package com.example.shardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.shardingjdbc.mapper")
@SpringBootApplication
public class ShardingjdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcApplication.class, args);
    }
}
