package com.gestion.registration_service.client; // <--- C'est le package du service INSCRIPTION

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Ce client permet au service d'inscription de parler au notification-service
@FeignClient(name = "notification-service")
public interface NotificationClient {

    @PostMapping("/notifications/confirmation")
    String envoyerConfirmation(@RequestBody String message);
}