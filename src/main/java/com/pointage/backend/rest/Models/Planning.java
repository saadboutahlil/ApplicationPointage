package com.pointage.backend.rest.Models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Planning{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long planningId;
	
	@Column
	public Date datePlanning;
	
	@Column
	public int nbrSemaine;
	
	
	@ManyToOne
	@JoinColumn(name = "managerId")
	private Manager manager;
	
	@ManyToOne
	@JoinColumn(name = "collaborateurId")
	private Collaborateur collaborateur;
	
	@ManyToOne
	@JoinColumn(name = "typePlannificationId")
	private TypePlannification typePlannification;

	public long getPlanningId() {
		return planningId;
	}

	public void setPlanningId(long planningId) {
		this.planningId = planningId;
	}

	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Date getDatePlanning() {
		return datePlanning;
	}

	public void setDatePlanning(Date datePlanning) {
		this.datePlanning = datePlanning;
	}

	public int getNbrSemaine() {
		return nbrSemaine;
	}

	public void setNbrSemaine(int nbrSemaine) {
		this.nbrSemaine = nbrSemaine;
	}

	public TypePlannification getTypePlannification() {
		return typePlannification;
	}

	public void setTypePlannification(TypePlannification typePlannification) {
		this.typePlannification = typePlannification;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	
	
}
