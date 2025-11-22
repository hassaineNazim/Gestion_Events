package com.gestion.event_service.model; // <--- C'est cette ligne qui est critique

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private String lieu;
    private LocalDate date;
    private Long organisateurId;

    public Evenement() {
    }

    public Evenement(String titre, String description, String lieu, LocalDate date, Long organisateurId) {
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.date = date;
        this.organisateurId = organisateurId;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Long getOrganisateurId() { return organisateurId; }
    public void setOrganisateurId(Long organisateurId) { this.organisateurId = organisateurId; }
}