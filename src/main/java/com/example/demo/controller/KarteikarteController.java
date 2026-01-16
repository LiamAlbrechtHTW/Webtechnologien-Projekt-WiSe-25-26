package com.example.demo.controller;

import com.example.demo.entity.Karteikarte;
import com.example.demo.service.KarteikarteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions/{sessionId}/cards")
@CrossOrigin(origins = "*")
public class KarteikarteController {

    private final KarteikarteService service;

    public KarteikarteController(KarteikarteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Karteikarte> getAll(@PathVariable String sessionId) {
        return service.getAll(sessionId);
    }

    @PostMapping
    public Karteikarte create(
            @PathVariable String sessionId,
            @RequestBody Karteikarte k
    ) {
        return service.create(sessionId, k);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable String sessionId,
            @PathVariable Long id
    ) {
        service.delete(sessionId, id);
    }

    @PutMapping("/{id}")
    public Karteikarte update(
            @PathVariable String sessionId,
            @PathVariable Long id,
            @RequestBody Karteikarte k
    ) {
        return service.update(sessionId, id, k);
    }
}
