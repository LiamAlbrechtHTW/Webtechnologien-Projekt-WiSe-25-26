package com.example.demo.service;

import com.example.demo.entity.Karteikarte;
import com.example.demo.repository.KarteikarteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class KarteikarteService {

    private final KarteikarteRepository repo;

    public KarteikarteService(KarteikarteRepository repo) {
        this.repo = repo;
    }

    public Karteikarte create(String sessionId, Karteikarte k) {
        validate(k);
        k.setId(null);
        k.setSessionId(sessionId);
        return repo.save(k);
    }

    public List<Karteikarte> getAll(String sessionId) {
        return repo.findBySessionId(sessionId);
    }

    @Transactional
    public void delete(String sessionId, Long cardId) {
        repo.deleteByIdAndSessionId(cardId, sessionId);
    }

    public Karteikarte update(String sessionId, Long cardId, Karteikarte input) {
        validate(input);

        Karteikarte existing = repo.findByIdAndSessionId(cardId, sessionId)
                .orElseThrow(() -> new NoSuchElementException("Karte nicht gefunden."));

        existing.setFrage(input.getFrage());
        existing.setAntwort(input.getAntwort());
        return repo.save(existing);
    }

    private void validate(Karteikarte k) {
        if (k.getFrage() == null || k.getFrage().isBlank()) {
            throw new IllegalArgumentException("Frage darf nicht leer sein.");
        }
        if (k.getAntwort() == null || k.getAntwort().isBlank()) {
            throw new IllegalArgumentException("Antwort darf nicht leer sein.");
        }
    }
}
