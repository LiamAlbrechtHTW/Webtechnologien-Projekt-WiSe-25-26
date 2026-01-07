package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KarteikarteService {

    @Autowired
    private KarteikarteRepository repo;

    public Karteikarte save(Karteikarte k) {
        return repo.save(k);
    }

    public List<Karteikarte> getAll() {
        List<Karteikarte> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list; 
    }
}
