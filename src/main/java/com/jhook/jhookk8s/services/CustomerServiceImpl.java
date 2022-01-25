package com.jhook.jhookk8s.services;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceImpl implements CustomerService {
    @GetMapping("/hello")
    @Override
    public String hello() {
        return "Hello Freind";
    }
}
