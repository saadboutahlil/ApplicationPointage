package com.pointage.backend.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointage.backend.rest.Models.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long>{

}
