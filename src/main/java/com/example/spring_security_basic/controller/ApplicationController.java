package com.example.spring_security_basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping(value = {"/greeting","/"})
    public String greeting() {
        return "Hello world";
    }
}
