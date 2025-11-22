package com.gestion.registration_service.controller;

import com.gestion.registration_service.model.Inscription;
import com.gestion.registration_service.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    // S'inscrire à un événement
    // POST http://localhost:8083/inscriptions
    @PostMapping
    public Inscription inscrire(@RequestBody Inscription inscription) {
        inscription.setDateInscription(java.time.LocalDateTime.now());
        inscription.setStatut("CONFIRMEE");
        return inscriptionRepository.save(inscription);
    }

    // Voir mes inscriptions (via mon ID de participant)
    // GET http://localhost:8083/inscriptions/participant/{id}
    @GetMapping("/participant/{id}")
    public List<Inscription> getInscriptionsParParticipant(@PathVariable Long id) {
        return inscriptionRepository.findByParticipantId(id);
    }

    // Voir qui est inscrit à un événement (pour l'organisateur)
    // GET http://localhost:8083/inscriptions/evenement/{id}
    @GetMapping("/evenement/{id}")
    public List<Inscription> getInscriptionsParEvenement(@PathVariable Long id) {
        return inscriptionRepository.findByEvenementId(id);
    }
}