package com.pointage.backend.rest.Controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pointage.backend.rest.DTO.ListReferentielDTO;
import com.pointage.backend.rest.DTO.PlanningDTO;
import com.pointage.backend.rest.Models.Planning;
import com.pointage.backend.rest.Service.PlanningService;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class PlanningController {
	@Autowired
	private PlanningService planningService;
	
	@GetMapping(value="/getReferentiel")
	public ListReferentielDTO getUsers() {
		return planningService.listReferentiel();
}
	
	@PostMapping(value="/savePlanning")
	public String savePlanning(@RequestBody PlanningDTO user) {
		Date aa=user.from;
		return planningService.savePlanning(user);
	}
	 @GetMapping("/plannings/{collaborateurId}")
	    public List<Planning> getPlanningsByCollaborateurId(@PathVariable long collaborateurId) {
	        return planningService.getPlanningsByCollaborateurId(collaborateurId);
	    }
}
