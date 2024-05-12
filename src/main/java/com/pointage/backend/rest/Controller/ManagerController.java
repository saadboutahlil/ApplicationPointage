package com.pointage.backend.rest.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.DTO.UtilisateurInfoDTO;
import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Information;
import com.pointage.backend.rest.Service.ManagerService;
import com.pointage.backend.rest.Service.UtilisateurService;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/manager") 
public class ManagerController {
	@Autowired
	private ManagerService _managerService;
	
	@GetMapping(value="/getCollaborateurs")
	public List<Collaborateur> getCollaborateurs() {
		return _managerService.getCollaborateurs();
}
}
