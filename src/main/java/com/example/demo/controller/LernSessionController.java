package com.example.demo.controller;

import com.example.demo.entity.LernSession;
import com.example.demo.service.LernSessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class LernSessionController {

    private final LernSessionService service;

    public LernSessionController(LernSessionService service) {
        this.service = service;
    }

    @GetMapping
    public List<LernSession> getAll() {
        return service.getAll();
    }

    @PostMapping
    public LernSession create(@RequestBody LernSession s) {
        return service.create(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
