package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola Mundo!";
    }
    @GetMapping("/adios")
    public String adios() {
        return "Adios Mundo!";
    }
    @GetMapping("/frase/{frase}")
    public static String toUpperCase(@PathVariable String frase){



        return frase.toUpperCase();

    }
 
    
}