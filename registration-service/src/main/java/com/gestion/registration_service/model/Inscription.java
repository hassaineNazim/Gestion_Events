package com.gestion.registration_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long evenementId;    // ID de l'événement
    private Long participantId;  // ID de l'utilisateur qui s'inscrit
    private LocalDateTime dateInscription;
    private String statut;       // Ex: "CONFIRMEE", "ANNULEE"

    public Inscription() {
    }

    public Inscription(Long evenementId, Long participantId, String statut) {
        this.evenementId = evenementId;
        this.participantId = participantId;
        this.dateInscription = LocalDateTime.now(); // Date automatique à l'instant T
        this.statut = statut;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEvenementId() { return evenementId; }
    public void setEvenementId(Long evenementId) { this.evenementId = evenementId; }
    public Long getParticipantId() { return participantId; }
    public void setParticipantId(Long participantId) { this.participantId = participantId; }
    public LocalDateTime getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDateTime dateInscription) { this.dateInscription = dateInscription; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}