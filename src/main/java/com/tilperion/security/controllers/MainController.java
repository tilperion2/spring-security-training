package com.tilperion.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/demo")
    public String getDemo() {
        return "Demo Time";
    }
}
