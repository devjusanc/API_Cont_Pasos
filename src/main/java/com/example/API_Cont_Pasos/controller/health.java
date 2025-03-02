package com.example.API_Cont_Pasos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class health {

    @GetMapping("/hola")
    public String decirHola() {
        return "¡Hola, mundo!";
    }
}
