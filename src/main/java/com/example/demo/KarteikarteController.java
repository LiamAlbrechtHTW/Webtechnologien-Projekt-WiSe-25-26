package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*")
public class KarteikarteController {

    private final KarteikarteService service;

    public KarteikarteController(KarteikarteService service) {
        this.service = service;
    }

    @PostMapping
    public Karteikarte create(@RequestBody Karteikarte k) {
        return service.create(k);
    }

    @GetMapping
    public List<Karteikarte> getAll() {
        return service.getAll();
    }
}
