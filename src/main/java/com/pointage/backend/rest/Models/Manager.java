package com.pointage.backend.rest.Models;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Manager extends Utilisateur {
	@OneToMany(cascade=CascadeType.ALL, mappedBy="manager")
	private List<Planning> planning;
}
