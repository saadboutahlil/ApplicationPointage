package com.pointage.backend.rest.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pointage.backend.rest.DTO.UtilisateurDTO;
import com.pointage.backend.rest.DTO.UtilisateurInfoDTO;
import com.pointage.backend.rest.Service.UtilisateurService;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class ApiController {
	@Autowired
	private UtilisateurService userService;
	@GetMapping(value="/")
	public String getPage() {
		return "first push";
	}
	@PostMapping(value="/save")
	public String saveUser(@RequestBody UtilisateurDTO user) {
		return userService.saveUser(user);
	}
	
	@PostMapping(value="/connexion")
	public UtilisateurInfoDTO CheckUtilisateur(@RequestBody UtilisateurDTO user) {
	return userService.verifierLogin(user.login,user.password);
	}

}
