package com.maximus.moexservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
@EnableFeignClients
public class MoexServiceApplication {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        SpringApplication.run(MoexServiceApplication.class, args);
//        B b = new B();
//        System.out.println(b);
    }
}

