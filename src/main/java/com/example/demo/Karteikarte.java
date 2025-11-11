package com.example.demo;

public class Karteikarte {
    private String frage;
    private String antwort;
    private Long id;

    // private boolean markiert = false;
    // private boolean Richtig = false;


    public Karteikarte(String frage, String antwort, Long id) {
        this.frage = frage;
        this.antwort = antwort;
        this.id = id;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
