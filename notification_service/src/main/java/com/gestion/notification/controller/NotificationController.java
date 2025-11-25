package com.gestion.notification.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping("/confirmation")
    public String envoyerConfirmation(@RequestBody String message) {
        // Ici, on utiliserait un vrai serveur mail (JavaMailSender) dans un vrai projet
        System.out.println("==================================================");
        System.out.println("ENVOI DE MAIL SIMULÉ : " + message);
        System.out.println("==================================================");
        return "Notification envoyée avec succès";
    }
}
