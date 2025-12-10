package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Karteikarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String frage;
    private String antwort;

    public Karteikarte() {}

    public Karteikarte(Long id, String frage, String antwort) {
        this.id = id;
        this.frage = frage;
        this.antwort = antwort;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFrage() { return frage; }
    public void setFrage(String frage) { this.frage = frage; }

    public String getAntwort() { return antwort; }
    public void setAntwort(String antwort) { this.antwort = antwort; }
}
