package com.gestion.registration_service.repository;

import com.gestion.registration_service.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    // Méthode magique pour trouver toutes les inscriptions d'un utilisateur spécifique
    List<Inscription> findByParticipantId(Long participantId);
    
    // Méthode magique pour trouver tous les participants d'un événement
    List<Inscription> findByEvenementId(Long evenementId);
}