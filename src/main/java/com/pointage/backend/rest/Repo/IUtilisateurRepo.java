package com.pointage.backend.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointage.backend.rest.Models.Utilisateur;

public interface IUtilisateurRepo extends JpaRepository<Utilisateur,Long>{
	  Utilisateur findByLoginAndPassword(String login, String password);
	  Utilisateur findByLogin (String login);
}
