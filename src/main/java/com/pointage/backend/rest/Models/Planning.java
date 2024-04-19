package com.pointage.backend.rest.Models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Planning{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long planingId;
	
	@Column
	public Date datePointage;
	
	@Column
	public Date heureEntree;
	
	@Column
	public Date heureSortie;
	
	@Column
	public int dureePause;
	
	@Column
	public String type;
	
	@Column
	public int NbrPointage;
	
	@ManyToOne
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilisateur;

	public long getPlaningId() {
		return planingId;
	}

	public void setPlaningId(long planingId) {
		this.planingId = planingId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNbrPointage() {
		return NbrPointage;
	}

	public void setNbrPointage(int nbrPointage) {
		NbrPointage = nbrPointage;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

	
	
	
}
