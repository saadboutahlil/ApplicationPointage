package com.pointage.backend.rest.Models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Information{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long informationId;
	
	@Column
	public int reliquat;
	
	@Column
	public float salaire;
	
	@Column
	public Date dateEmbauche;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "collaborateurId")
    private Collaborateur collaborateur;

	public long getInformationId() {
		return informationId;
	}

	public void setInformationId(long informationId) {
		this.informationId = informationId;
	}

	public int getReliquat() {
		return reliquat;
	}

	public void setReliquat(int reliquat) {
		this.reliquat = reliquat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	

	
	
}
