package com.pointage.backend.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.DTO.UtilisateurInfoDTO;
import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Manager;
import com.pointage.backend.rest.Models.Planning;
import com.pointage.backend.rest.Models.Utilisateur;
import com.pointage.backend.rest.Repo.ICollaborateurRepo;
import com.pointage.backend.rest.Repo.IUtilisateurRepo;

import utiliies.Profil;
@Service
public class ManagerService {
	private final ICollaborateurRepo collaborateurRepo;
	
	   @Autowired
	    public ManagerService(ICollaborateurRepo collaborateurRepo) {
	        this.collaborateurRepo = collaborateurRepo;
	    }
	   
	   public List<Collaborateur> getCollaborateurs() {
	        return this.collaborateurRepo.findAll();
	        }
}
