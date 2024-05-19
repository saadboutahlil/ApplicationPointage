package com.pointage.backend.rest.Controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointage.backend.rest.DTO.PlanningDTO;
import com.pointage.backend.rest.DTO.PointageDTO;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.DTO.UtilisateurInfoDTO;
import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Information;
import com.pointage.backend.rest.Models.Pointage;
import com.pointage.backend.rest.Service.CollaborateurService;
import com.pointage.backend.rest.Service.ManagerService;
import com.pointage.backend.rest.Service.UtilisateurService;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/collaborateur") 
public class CollaborateurController {
	@Autowired
	private CollaborateurService _collaborateurService;
	
	@PostMapping(value="/badge")
	public String badger(@RequestBody PointageDTO pointage) {
		return _collaborateurService.badger(pointage.badge,pointage.collaborateurId);
	}
	@PutMapping(value="/debadge")
	public String debadger(@RequestBody PointageDTO pointage) {
		return _collaborateurService.debadger(pointage.badge,pointage.collaborateurId);
	}
	   @GetMapping("/{collaborateurId}/last-pointage")
	    public  Optional<Pointage> getLastPointage(@PathVariable Long collaborateurId) {
	        return _collaborateurService.getLastPointageByCollaborateur(collaborateurId);
	    }
}
