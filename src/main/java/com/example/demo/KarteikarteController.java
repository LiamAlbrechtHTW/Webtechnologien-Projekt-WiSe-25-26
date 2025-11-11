package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*")
public class KarteikarteController {

    @GetMapping("/karteikarte")
    public String Hello() {
        return "Hallo, willkommen im Karteikarten-System!";
    }


    public List<Karteikarte> getAllCards() {
        return List.of(
                new Karteikarte("Was ist die Hauptstadt von Deutschland?", "Berlin", "1"),
                new Karteikarte("Was ist 2 + 2?", "4", "2"),
                new Karteikarte("Was ist die Hauptstadt von Frankreich?", "Paris", "3")
        );
    }
}