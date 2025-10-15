package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KarteikarteController {

    @GetMapping("/karteikarten")
    public String Hello() {
        return "Hallo, willkommen im Karteikarten-System!";
    }

}
