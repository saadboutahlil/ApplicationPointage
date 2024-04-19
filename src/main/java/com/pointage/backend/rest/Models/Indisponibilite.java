package com.pointage.backend.rest.Models;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Indisponibilite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long indisponibiliteId;
	
	@Column
	public String type;
	
	@Column
	public Date datedebut;
	
	@Column
	public Date datefin;
	
	@Column
	public String etat;
	
	@Column
	public int duree;
	
	@ManyToOne
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilisateur;

	public long getIndisponibiliteid() {
		return indisponibiliteId;
	}

	public void setIndisponibiliteid(long indisponibiliteid) {
		this.indisponibiliteId = indisponibiliteid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
	

}
