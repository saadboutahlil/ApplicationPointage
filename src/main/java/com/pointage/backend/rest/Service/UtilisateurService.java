package com.pointage.backend.rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Manager;
import com.pointage.backend.rest.Models.Utilisateur;
import com.pointage.backend.rest.Repo.IUtilisateurRepo;

import utiliies.Profil;
@Service
public class UtilisateurService {
	private final IUtilisateurRepo utilisateurRepo;
	
	   @Autowired
	    public UtilisateurService(IUtilisateurRepo utilisateurRepo) {
	        this.utilisateurRepo = utilisateurRepo;
	    }
	   
	   
	   public String saveUser(UtilisateurDTO user) {
		   if(user.profil==Profil.COLLABORATEUR) {
			   utilisateurRepo.save(convertirDTOVersCollaborateur(user));
		   }
		   else if(user.profil==Profil.MANAGER){
			   utilisateurRepo.save(convertirDTOVersManager(user));
		   }
			return "Saved";
		}
	   
	    public Collaborateur convertirDTOVersCollaborateur(UtilisateurDTO utilisateurDTO) {
	    	Collaborateur utilisateur = new Collaborateur();
	        utilisateur.setNom(utilisateurDTO.nom);
	        utilisateur.setPrenom(utilisateurDTO.prenom);
	        utilisateur.setDateNaissance(utilisateurDTO.dateNaissance);
	        utilisateur.setTelephone(utilisateurDTO.telephone);
	        utilisateur.setEmail(utilisateurDTO.email);
	        utilisateur.setLogin(utilisateurDTO.login);
	        utilisateur.setPassword(utilisateurDTO.password);
	        return utilisateur;
	    }
	    
	    public Manager convertirDTOVersManager(UtilisateurDTO utilisateurDTO) {
	    	Manager utilisateur = new Manager();
	        utilisateur.setNom(utilisateurDTO.nom);
	        utilisateur.setPrenom(utilisateurDTO.prenom);
	        utilisateur.setDateNaissance(utilisateurDTO.dateNaissance);
	        utilisateur.setTelephone(utilisateurDTO.telephone);
	        utilisateur.setEmail(utilisateurDTO.email);
	        utilisateur.setLogin(utilisateurDTO.login);
	        utilisateur.setPassword(utilisateurDTO.password);
	        return utilisateur;
	    }
	    public boolean verifierLogin(String login, String password) {
	       Utilisateur utilisateur = utilisateurRepo.findByLoginAndPassword(login, password);
	       return utilisateur != null;
	    }
}
