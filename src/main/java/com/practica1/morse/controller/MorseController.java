package com.practica1.morse.controller;

import com.practica1.morse.entities.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decode")
public class MorseController {

    @GetMapping("/morse/{code}")
    public Morse decodeMorse(@PathVariable(value = "code") String codeUrl) {
        try{
            Morse morse = new Morse(codeUrl);
            morse.decodeMorse();
            return morse;
        } catch (Exception e) {
            return null;
        }
    }
}
