package com.pointage.backend.rest.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;





@Entity
public class Rubrique {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long rubriqueId;
	
	@Column
	public String Type;
	
	@Column
	public String Description;
	
	@ManyToOne
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilisateur;
	public long getRubriqueid() {
		return rubriqueId;
	}

	public void setRubriqueid(long _rubriqueid) {
		rubriqueId = _rubriqueid;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
