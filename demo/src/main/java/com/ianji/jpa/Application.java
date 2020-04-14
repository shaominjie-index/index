package com.ianji.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class Application {
    public static void main(String[] args) {
        try{
            SpringApplication.run(Application.class, args);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
