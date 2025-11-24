package com.gestion.registration_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.registration_service.model.EventBean;

// name = nom exact du service cible tel qu'il apparaît dans Eureka
@FeignClient(name = "event-service")
public interface EventClient {

    // On recopie la signature de la méthode GET du EventController
    // Mais on crée une classe "EventBean" simplifiée juste après
    @GetMapping("/events/{id}")
    EventBean getEventById(@PathVariable("id") Long id);

    @PostMapping("/notifications/confirmation")
    String envoyerConfirmation(@RequestBody String message);
}