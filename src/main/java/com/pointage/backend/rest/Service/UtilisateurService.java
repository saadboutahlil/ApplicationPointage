package com.pointage.backend.rest.Service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.DTO.UtilisateurInfoDTO;
import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Manager;
import com.pointage.backend.rest.Models.RH;
import com.pointage.backend.rest.Models.Utilisateur;
import com.pointage.backend.rest.Repo.IUtilisateurRepo;

import utiliies.PasswordUtils;
import utiliies.Profil;
@Service
public class UtilisateurService {
	private final IUtilisateurRepo utilisateurRepo;
	
	   @Autowired
	    public UtilisateurService(IUtilisateurRepo utilisateurRepo) {
	        this.utilisateurRepo = utilisateurRepo;
	    }
	   
	   public String saveUser(UtilisateurDTO user) {
		   try {
		   if(user.profil==Profil.COLLABORATEUR) {
			   utilisateurRepo.save(convertirDTOVersCollaborateur(user));
				return "Saved";
		   }
		   else if(user.profil==Profil.MANAGER){
			   utilisateurRepo.save(convertirDTOVersManager(user));
		   }
		   else if(user.profil==Profil.RH){
			   utilisateurRepo.save(convertirDTOVersRH(user));
		   }
			return "Saved";
		   }
		   
		   catch(Exception x) {
			   return x.getMessage();
		   }
		   
		}
	   
	    public Collaborateur convertirDTOVersCollaborateur(UtilisateurDTO utilisateurDTO) throws NoSuchAlgorithmException {
	    	Collaborateur utilisateur = new Collaborateur();
	        utilisateur.setNom(utilisateurDTO.nom);
	        utilisateur.setPrenom(utilisateurDTO.prenom);
	        utilisateur.setDateNaissance(utilisateurDTO.dateNaissance);
	        utilisateur.setTelephone(utilisateurDTO.telephone);
	        utilisateur.setEmail(utilisateurDTO.email);
	        utilisateur.setLogin(utilisateurDTO.login);
	        utilisateur.setPassword(PasswordUtils.encryptPassword(utilisateurDTO.password));
	        return utilisateur;
	    }

	    public Manager convertirDTOVersManager(UtilisateurDTO utilisateurDTO) throws NoSuchAlgorithmException {
	    	Manager utilisateur = new Manager();
	        utilisateur.setNom(utilisateurDTO.nom);
	        utilisateur.setPrenom(utilisateurDTO.prenom);
	        utilisateur.setDateNaissance(utilisateurDTO.dateNaissance);
	        utilisateur.setTelephone(utilisateurDTO.telephone);
	        utilisateur.setEmail(utilisateurDTO.email);
	        utilisateur.setLogin(utilisateurDTO.login);
	        utilisateur.setPassword(PasswordUtils.encryptPassword(utilisateurDTO.password));
	        return utilisateur;
	    }
	    public RH convertirDTOVersRH(UtilisateurDTO utilisateurDTO) throws NoSuchAlgorithmException {
	    	RH utilisateur = new RH();
	        utilisateur.setNom(utilisateurDTO.nom);
	        utilisateur.setPrenom(utilisateurDTO.prenom);
	        utilisateur.setDateNaissance(utilisateurDTO.dateNaissance);
	        utilisateur.setTelephone(utilisateurDTO.telephone);
	        utilisateur.setEmail(utilisateurDTO.email);
	        utilisateur.setLogin(utilisateurDTO.login);
	        utilisateur.setPassword(PasswordUtils.encryptPassword(utilisateurDTO.password));
	        return utilisateur;
	    }
	    public UtilisateurInfoDTO verifierLogin(String login, String password) throws NoSuchAlgorithmException {
	       Utilisateur utilisateur = utilisateurRepo.findByLogin(login);
	       if (utilisateur != null) {
	    	   String encryptedPassword = utilisateur.getPassword();
	    	   if(PasswordUtils.matchPasswords(password, encryptedPassword)) {
		            String userType = utilisateur.getClass().getSimpleName();
		            return new UtilisateurInfoDTO(userType, utilisateur);
	    	   }
	    	   else {
	    		   return null;
	    	   }

	        } else {
	            return null;
	        }
	    }
}
