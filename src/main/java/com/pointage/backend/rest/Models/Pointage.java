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
	public int nbrSemaine;
	
	@Column
	public Date heureEntree;
	
	@Column
	public Date heureSortie;
	
	@Column
	public int dureePause;
	
	@Column
	public int nbrPointage;
	
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

	public Date getHeureEntree() {
		return heureEntree;
	}

	public void setHeureEntree(Date heureEntree) {
		this.heureEntree = heureEntree;
	}

	public Date getHeureSortie() {
		return heureSortie;
	}

	public void setHeureSortie(Date heureSortie) {
		this.heureSortie = heureSortie;
	}

	public int getDureePause() {
		return dureePause;
	}

	public void setDureePause(int dureePause) {
		this.dureePause = dureePause;
	}

	public int getNbrPointage() {
		return nbrPointage;
	}

	public void setNbrPointage(int nbrPointage) {
		this.nbrPointage = nbrPointage;
	}

	public int getNbrSemaine() {
		return nbrSemaine;
	}

	public void setNbrSemaine(int nbrSemaine) {
		this.nbrSemaine = nbrSemaine;
	}


	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	
	
}
