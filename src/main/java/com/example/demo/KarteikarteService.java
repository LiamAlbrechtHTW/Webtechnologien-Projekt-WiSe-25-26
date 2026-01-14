package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KarteikarteService {

    private final KarteikarteRepository repo;

    public KarteikarteService(KarteikarteRepository repo) {
        this.repo = repo;
    }

    public Karteikarte create(Karteikarte k) {
        if (k.getFrage() == null || k.getFrage().isBlank()) {
            throw new IllegalArgumentException("Frage darf nicht leer sein.");
        }
        if (k.getAntwort() == null || k.getAntwort().isBlank()) {
            throw new IllegalArgumentException("Antwort darf nicht leer sein.");
        }
        return repo.save(k);
    }

    public List<Karteikarte> getAll() {
        List<Karteikarte> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
