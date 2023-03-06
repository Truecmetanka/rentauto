package ru.matrosov.rentauto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentAutoController {
    @GetMapping("/hello")
    public String test() {
        return "hello";
    }
}
