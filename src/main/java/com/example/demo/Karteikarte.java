package com.example.demo;

public class Karteikarte {
    private String id;
    private String frage;
    private String antwort;

    // private boolean markiert = false;
    // private boolean Richtig = false;


    public Karteikarte(String frage, String antwort, String id) {
        this.id = id;
        this.frage = frage;
        this.antwort = antwort;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
