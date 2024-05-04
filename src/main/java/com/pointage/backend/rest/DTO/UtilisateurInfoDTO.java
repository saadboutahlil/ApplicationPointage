package com.pointage.backend.rest.DTO;

import com.pointage.backend.rest.Models.Utilisateur;

public   class UtilisateurInfoDTO {

    private String type;
    private Utilisateur utilisateur;

    public UtilisateurInfoDTO(String type, Utilisateur utilisateur) {
        this.type = type;
        this.utilisateur = utilisateur;
    }

    public String getType() {
        return type;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}