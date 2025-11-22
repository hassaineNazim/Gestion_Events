package com.gestion.user_service.repository;

import com.gestion.user_service.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Spring Data JPA génère le code automatiquement
}