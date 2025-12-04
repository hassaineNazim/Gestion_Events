package com.gestion.user_service.service;

import com.gestion.user_service.model.Utilisateur;
import com.gestion.user_service.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // C'EST ICI QUE SE TROUVE LA MÉTHODE !
    public String saveUser(Utilisateur user) {
        // 1. On crypte le mot de passe
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 2. Si aucun rôle n'est donné, on force "PARTICIPANT"
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("PARTICIPANT");
        }

        // 3. On sauvegarde en base de données
        repository.save(user);
        return "Utilisateur ajouté avec succès !";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
}