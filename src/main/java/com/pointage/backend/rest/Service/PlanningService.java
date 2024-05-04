package com.pointage.backend.rest.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointage.backend.rest.DTO.ListReferentielDTO;
import com.pointage.backend.rest.DTO.PlanningDTO;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Planning;
import com.pointage.backend.rest.Models.TypePlannification;
import com.pointage.backend.rest.Repo.ICollaborateurRepo;
import com.pointage.backend.rest.Repo.IPlanningRepo;
import com.pointage.backend.rest.Repo.ITypePlannificationRepo;

import utiliies.Profil;
@Service
public class PlanningService {
	private final ITypePlannificationRepo typePlanificationRepo;
	private final ICollaborateurRepo collaborateurRepo;
	private final IPlanningRepo planningRepo;
	
	   @Autowired
	    public PlanningService(ITypePlannificationRepo typePlanificationRepo,ICollaborateurRepo collaborateurRepo,
	    		IPlanningRepo planningRepo) {
	        this.typePlanificationRepo = typePlanificationRepo;
	        this.collaborateurRepo=collaborateurRepo;
	        this.planningRepo=planningRepo;
	    }
	   public ListReferentielDTO listReferentiel(){
		   List<Collaborateur> listcoll=new ArrayList<>();
		   List<TypePlannification> listtypePlanification=new ArrayList<>();
		   
		   listtypePlanification.addAll(this.typePlanificationRepo.findAllBy());
		   listcoll.addAll(this.collaborateurRepo.findAll());
		   
		   ListReferentielDTO a=new ListReferentielDTO();
		   a.listCollaborateur=listcoll;
		   a.listTypePlannification=listtypePlanification;
         return a;		   
	   }
	   
	   
	   
	   public String savePlanning(PlanningDTO plandto) {
	       Instant instantFrom = plandto.from.toInstant();
	        Instant instantTo = plandto.to.toInstant();

	        // Calculate duration between the two instants
	        Duration duration = Duration.between(instantFrom, instantTo);

	        // Convert duration to days
	        long days = duration.toDays();

	        int nbrJour= (int) days+1;
	        
	        for(int i=0;i<nbrJour;i++) {
	          	Planning planning = new Planning();
	          	planning.setDatePlanning(Date.from(instantFrom.plus(i, ChronoUnit.DAYS)));
	          	planning.setCollaborateur(this.collaborateurRepo.getById(plandto.collaborateurId));
	          	planning.setTypePlannification(this.typePlanificationRepo.getById(plandto.typePlanningId));
	          	planning.setNbrSemaine(3);
	        	this.planningRepo.save(planning);
	        }
	        return "saved";
		   
		}
	   public List<Planning> getPlanningsByCollaborateurId(long collaborateurId) {
	        return this.planningRepo.findByCollaborateur_UtilisateurId(collaborateurId);
	    }
}
