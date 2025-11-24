package com.gestion.registration_service.controller;

import com.gestion.registration_service.client.EventClient;
import com.gestion.registration_service.client.NotificationClient;
import com.gestion.registration_service.model.EventBean;
import com.gestion.registration_service.model.Inscription;
import com.gestion.registration_service.model.InscriptionComplete;
import com.gestion.registration_service.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inscriptions")
@CrossOrigin(origins = "http://localhost:4200")
public class InscriptionController {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EventClient eventClient;

    @Autowired
    private NotificationClient notificationClient;

    // S'inscrire à un événement
    @PostMapping
    public Inscription inscrire(@RequestBody Inscription inscription) {
        // 1. Préparer les données
        inscription.setDateInscription(java.time.LocalDateTime.now());
        inscription.setStatut("CONFIRMEE");

        // 2. Sauvegarder l'inscription en base
        Inscription saved = inscriptionRepository.save(inscription);

        // 3. Envoyer la notification (Email simulé)
        String msg = "Confirmation : L'utilisateur " + inscription.getParticipantId() +
                " est bien inscrit à l'événement " + inscription.getEvenementId();

        try {
            notificationClient.envoyerConfirmation(msg);
        } catch (Exception e) {
            // On loggue l'erreur mais on ne bloque pas l'inscription si le service notif
            // est éteint
            System.err.println("Le service de notification semble éteint ou injoignable : " + e.getMessage());
        }

        return saved;
    }

    // Voir mes inscriptions (Avec les détails de l'événement récupérés via Feign)
    @GetMapping("/participant/{id}")
    public List<InscriptionComplete> getInscriptionsParParticipant(@PathVariable Long id) {
        // 1. Récupérer les inscriptions brutes
        List<Inscription> inscriptions = inscriptionRepository.findByParticipantId(id);
        List<InscriptionComplete> resultat = new ArrayList<>();

        // 2. Enrichir chaque inscription avec les infos de l'événement
        for (Inscription ins : inscriptions) {
            // Appel distant au microservice Event (8082)
            EventBean event = eventClient.getEventById(ins.getEvenementId());

            // Création de l'objet combiné
            resultat.add(new InscriptionComplete(ins, event));
        }

        return resultat;
    }

    // Voir qui est inscrit à un événement (pour l'organisateur)
    @GetMapping("/evenement/{id}")
    public List<Inscription> getInscriptionsParEvenement(@PathVariable Long id) {
        return inscriptionRepository.findByEvenementId(id);
    }
}