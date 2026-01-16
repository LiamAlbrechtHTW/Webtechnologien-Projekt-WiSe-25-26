package com.example.demo.service;

import com.example.demo.entity.LernSession;
import com.example.demo.repository.LernSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LernSessionService {

    private final LernSessionRepository repo;

    public LernSessionService(LernSessionRepository repo) {
        this.repo = repo;
    }

    public List<LernSession> getAll() {
        return repo.findAll();
    }

    public LernSession create(LernSession s) {
        if (s.getName() == null || s.getName().isBlank()) {
            throw new IllegalArgumentException("Name darf nicht leer sein.");
        }
        s.setId(null);
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
