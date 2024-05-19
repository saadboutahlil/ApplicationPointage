package com.pointage.backend.rest.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Pointage;
import com.pointage.backend.rest.Repo.ICollaborateurRepo;
import com.pointage.backend.rest.Repo.IPointageRepo;
@Service
public class CollaborateurService {
	private final ICollaborateurRepo collaborateurRepo;
	private final IPointageRepo pointageRepo;
	
	   @Autowired
	    public CollaborateurService(ICollaborateurRepo collaborateurRepo,IPointageRepo pointageRepo) {
	        this.collaborateurRepo = collaborateurRepo;
	        this.pointageRepo = pointageRepo;
	    }
	   
	   public String badger(boolean badge, long collaborateurId ) {
		   try {
		   	      Pointage a=new Pointage(); 
		   	      a.setCollaborateur(this.collaborateurRepo.getById(collaborateurId));
		   	   Date now=new Date();
		   	      a.setDatePointage(now);
		   	   SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		   	      a.setHeureEntree(formatter.format(now));
			   this.pointageRepo.save(a);
		   	        return "saved";
		   }
		   catch(Exception x) {
		   	return x.getMessage();
		   }
}
	   public Optional<Pointage> getLastPointageByCollaborateur(long collaborateurId) {
	        Optional<Collaborateur> collaborateurOptional = collaborateurRepo.findById(collaborateurId);
	        if (collaborateurOptional.isPresent()) {
	            Collaborateur collaborateur = collaborateurOptional.get();
	            List<Pointage> pointages = pointageRepo.findByCollaborateurOrderByDatePointageDesc(collaborateur);
	            return pointages.isEmpty() ? Optional.empty() : Optional.of(pointages.get(0));
	        } else {
	            return Optional.empty();
	        }
	    }

	   public String debadger( boolean badge, long collaborateurId) {
	        // Récupérer le dernier pointage du collaborateur par son ID
	        Optional<Collaborateur> collaborateurOptional = collaborateurRepo.findById(collaborateurId);
	        if (collaborateurOptional.isPresent()) {
	            Collaborateur collaborateur = collaborateurOptional.get();
	            Optional<Pointage> lastPointageOptional = pointageRepo.findFirstByCollaborateurOrderByDatePointageDesc(collaborateur);
	            if (lastPointageOptional.isPresent()) {
	                Pointage lastPointage = lastPointageOptional.get();
	           	   Date now=new Date();
			   	   SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	                lastPointage.setHeureSortie(formatter.format(now));
	                
	                // Enregistrer le dernier pointage mis à jour dans la base de données
	                 pointageRepo.save(lastPointage);
	                 return "updated";
	            } else {
	                throw new IllegalArgumentException("Aucun pointage trouvé pour le collaborateur avec l'ID: " + collaborateurId);
	            }
	        } else {
	            throw new IllegalArgumentException("Collaborateur non trouvé avec l'ID: " + collaborateurId);
	        }
	    }
}
