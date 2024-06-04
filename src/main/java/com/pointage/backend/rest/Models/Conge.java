 package com.pointage.backend.rest.Models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Conge{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long CongeId;
	
	@Column
	public int nbrJour;
	
	
	@Column
	public Date dateConge;
	
	
	@Column(nullable = true)
	public Boolean isValidManager;
	
	@ManyToOne
	@JoinColumn(name = "collaborateurId")
    private Collaborateur collaborateur;

	public long getCongeId() {
		return CongeId;
	}

	public void setCongeId(long congeId) {
		CongeId = congeId;
	}

	public int getNbrJour() {
		return nbrJour;
	}

	public void setNbrJour(int nbrJour) {
		this.nbrJour = nbrJour;
	}

	public Date getDateConge() {
		return dateConge;
	}

	public void setDateConge(Date dateConge) {
		this.dateConge = dateConge;
	}


	public boolean isValidManager() {
	    // Check if isValidManager is not null, and return its boolean value
	    return isValidManager != null && isValidManager.booleanValue();
	}

	public void setValidManager(Boolean isValidManager) {
		this.isValidManager = isValidManager;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	
	
}
