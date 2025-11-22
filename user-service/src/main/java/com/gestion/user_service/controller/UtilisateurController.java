package com.gestion.user_service.controller;

import com.gestion.user_service.model.Utilisateur;
import com.gestion.user_service.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // Toutes les URLs commenceront par /users
public class UtilisateurController {

    @Autowired // Injection de dépendance : on récupère le repository créé par Spring
    private UtilisateurRepository utilisateurRepository;

    // GET http://localhost:8081/users -> Affiche tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // POST http://localhost:8081/users -> Crée un utilisateur
    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
}