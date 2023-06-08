package com.example.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {


    @GetMapping("/hello")
    public String alpha(){
        System.out.println("Да Пошел ты нахуй сука такая");
        return "Hello!";
    }
}
