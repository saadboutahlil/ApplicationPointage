package com.pointage.backend.rest.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.DTO.UtilisateurInfoDTO;
import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Conge;
import com.pointage.backend.rest.Models.Manager;
import com.pointage.backend.rest.Models.Planning;
import com.pointage.backend.rest.Models.Pointage;
import com.pointage.backend.rest.Models.Utilisateur;
import com.pointage.backend.rest.Repo.ICollaborateurRepo;
import com.pointage.backend.rest.Repo.ICongeRepo;
import com.pointage.backend.rest.Repo.IPointageRepo;
import com.pointage.backend.rest.Repo.IUtilisateurRepo;

import utiliies.Profil;
@Service
public class ManagerService {
	private final ICollaborateurRepo collaborateurRepo;
	private final IPointageRepo pointageRepo;
	private final ICongeRepo congeRepo;
	
	   @Autowired
	    public ManagerService(ICollaborateurRepo collaborateurRepo,IPointageRepo pointageRepo,ICongeRepo congeRepo) {
	        this.collaborateurRepo = collaborateurRepo;
	        this.pointageRepo=pointageRepo;
	        this.congeRepo=congeRepo;
	    }
	   
	   public List<Collaborateur> getCollaborateurs() {
	        return this.collaborateurRepo.findAll();
	        }
	   
	   public Map<Collaborateur, List<Pointage>> getPointagesGroupedByCollaborateur(String datePointage) {
		   // Récupérer tous les pointages
		    List<Pointage> allPointages = pointageRepo.findAll();
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    // Filtrer les pointages par datePointage
		    List<Pointage> filteredPointages = allPointages.stream()
	                .filter(pointage -> {
	                    // Convertir datePointage en chaîne avec le même format
	                    String formattedDate = formatter.format(pointage.datePointage);
	                    // Comparer avec la datePointage fournie
	                    return formattedDate.equals(datePointage);
	                })
	                .collect(Collectors.toList());

		    // Grouper les pointages filtrés par collaborateur
		    return filteredPointages.stream()
		            .collect(Collectors.groupingBy(Pointage::getCollaborateur));
	    }
	   
	   public String changeEtat(boolean val, long congeId ) {
		   try {
			 Optional<Conge> congeOptinnal = congeRepo.findById(congeId);
			 if(congeOptinnal!=null) {
			      Conge congeup = congeOptinnal.get();
			      congeup.setValidManager(val);
			      congeRepo.save(congeup);
	                 return "updated";
			 }
			 else {
				 return "introuvable";
			 }
		   }
		   catch(Exception x) {
		   	return x.getMessage();
		   }
}
}
