package com.tilperion.security.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/demo")
    public String getDemo() {
        return "Demo Time";
    }

    @CrossOrigin("*")
    @GetMapping("/public")
    public String getPublic() {
        return "Public Page";
    }

    @PostMapping("/post")
    public String postMe() {
        return "Posted";
    }

    @PostMapping("/post2")
    public String postMe2() {
        return "Posted 2";
    }
}
