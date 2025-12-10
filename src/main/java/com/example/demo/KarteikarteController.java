package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*")
public class KarteikarteController {

    @Autowired
    private KarteikarteService service;

    @PostMapping("/karteikarten")
    public Karteikarte create(@RequestBody Karteikarte k) {
        return service.save(k);
    }

    @GetMapping("/karteikarten")
    public List<Karteikarte> getAll() {
        return service.getAll();
    }
}