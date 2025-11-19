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

    @GetMapping
    public List<Karteikarte> getAllCards() {
        return List.of(
                new Karteikarte("1", "Was ist die Hauptstadt von Deutschland?", "Berlin"),
                new Karteikarte("2", "Was ist 2 + 2?", "4"),
                new Karteikarte("3", "Was ist die Hauptstadt von Frankreich?", "Paris")
        );
    }
}