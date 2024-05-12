package com.pointage.backend.rest.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Utilisateur;

public interface ICollaborateurRepo extends JpaRepository<Collaborateur,Long>{
	  Collaborateur findByUtilisateurId(int utilisateurId);
	   List<Collaborateur> findAll();
}
