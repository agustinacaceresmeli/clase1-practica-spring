package com.practica1.morse.controllers;

import com.practica1.morse.entities.MorseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decode")
public class MorseController {

    @GetMapping("/morse/{code}")
    public MorseCode decodeMorse(@PathVariable(value = "code") String codeUrl) {
        try{
            MorseCode morse = new MorseCode(codeUrl);
            morse.decodeMorse();
            return morse;
        } catch (Exception e) {
            return null;
        }
    }
}
