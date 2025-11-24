package com.gestion.registration_service.model;

import java.time.LocalDate;

// Ce n'est PAS une @Entity, juste une classe simple pour transporter les données
public class EventBean {
    private Long id;
    private String titre;
    private String lieu;
    private LocalDate date;

    // Getters et Setters (Générez-les ou copiez-les)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}