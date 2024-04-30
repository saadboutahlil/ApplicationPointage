package com.pointage.backend.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.Service.UtilisateurService;


@RestController
public class ApiController {
	@Autowired
	private UtilisateurService userService;
	@GetMapping(value="/")
	public String getPage() {
		return "first push";
	}
	@PostMapping(value="/save")
	public String saveUser(@RequestBody UtilisateurDTO user) {
		userService.saveUser(user);
		return "Saved";
	}
	
	@GetMapping(value="/connexion")
	public String CheckUtilisateur(@RequestBody UtilisateurDTO user) {
	if(userService.verifierLogin(user.login,user.password)) {
		return "Trouvé";
	}
		return "Inexistant";
		}

}
