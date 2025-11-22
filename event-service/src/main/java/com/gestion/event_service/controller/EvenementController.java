package com.gestion.event_service.controller;

import com.gestion.event_service.model.Evenement;
import com.gestion.event_service.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*") //allow all origin
public class EvenementController {

    @Autowired
    private EvenementRepository evenementRepository;

    // 1. Récupérer tous les événements
    // GET http://localhost:8082/events
    @GetMapping
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    // 2. Créer un nouvel événement
    // POST http://localhost:8082/events
    @PostMapping
    public Evenement createEvenement(@RequestBody Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    // 3. Récupérer un événement spécifique par son ID
    // GET http://localhost:8082/events/{id}
    @GetMapping("/{id}")
    public Evenement getEvenementById(@PathVariable Long id) {
        return evenementRepository.findById(id).orElse(null);
    }
}