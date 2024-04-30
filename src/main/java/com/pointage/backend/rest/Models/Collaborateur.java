package com.pointage.backend.rest.Models;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Collaborateur extends Utilisateur{
	@OneToMany(cascade=CascadeType.ALL, mappedBy="collaborateur")
	private List<Planning> planning;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "informationId", referencedColumnName = "informationId")
    private Information information;
}
