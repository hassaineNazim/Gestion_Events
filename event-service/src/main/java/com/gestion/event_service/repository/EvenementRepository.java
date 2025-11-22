package com.gestion.event_service.repository;

import com.gestion.event_service.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    // Spring crée automatiquement les méthodes save(), findAll(), findById()...
}