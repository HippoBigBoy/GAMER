package za.co.dinoko.assignment.ayeshaMatwadia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello World";
    }
}
