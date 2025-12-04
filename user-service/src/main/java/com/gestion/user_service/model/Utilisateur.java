package com.gestion.user_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Dit à Spring : "Ceci est une table dans la base de données"
public class Utilisateur {

    @Id // Dit : "Ceci est la clé primaire (ID unique)"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // L'ID s'auto-incrémente (1, 2, 3...)
    private Long id;

    private String nom;
    private String email;
    private String password;
    private String role; // "ORGANISATEUR" ou "PARTICIPANT"

    // Constructeur vide (Obligatoire pour JPA)
    public Utilisateur() {
    }

    // Constructeur pratique
    public Utilisateur(String nom, String email, String password, String role) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters et Setters (Pour accéder aux données)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}