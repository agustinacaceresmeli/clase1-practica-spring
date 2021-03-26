package com.practica1.romanNumber.controllers;

import com.practica1.romanNumber.entities.RomanNumber;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/number")
public class RomanNumberController {

    @GetMapping("/convert/{number}")
    public RomanNumber convertRomanNumber(@PathVariable(value = "number") String numberUrl) {
        return new RomanNumber().convertToRomanNumber(Integer.parseInt(numberUrl));
    }
}