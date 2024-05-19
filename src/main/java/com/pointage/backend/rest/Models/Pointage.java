package com.pointage.backend.rest.Models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Pointage{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long pointageId;
	
	@Column
	public Date datePointage;
	@Column
	public String heureEntree;
	
	@Column
	public String heureSortie;
	
	
	@ManyToOne
	@JoinColumn(name = "collaborateurId")
	private Collaborateur collaborateur;
	
	
	
	

	public long getPointageId() {
		return pointageId;
	}

	public void setPointageId(long pointageId) {
		this.pointageId = pointageId;
	}

	public Date getDatePointage() {
		return datePointage;
	}

	public void setDatePointage(Date datePointage) {
		this.datePointage = datePointage;
	}

	public String getHeureEntree() {
		return heureEntree;
	}

	public void setHeureEntree(String heureEntree) {
		this.heureEntree = heureEntree;
	}

	public String getHeureSortie() {
		return heureSortie;
	}

	public void setHeureSortie(String heureSortie) {
		this.heureSortie = heureSortie;
	}


	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	
	
}
