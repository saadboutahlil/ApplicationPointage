package com.pointage.backend.rest.DTO;


import java.util.List;

import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.TypePlannification;
public class ListReferentielDTO {
	public List<Collaborateur> listCollaborateur;
	public List<TypePlannification> listTypePlannification;
	public List<Collaborateur> getListCollaborateur() {
		return listCollaborateur;
	}
	public void setListCollaborateur(List<Collaborateur> listCollaborateur) {
		this.listCollaborateur = listCollaborateur;
	}
	public List<TypePlannification> getListPlanning() {
		return listTypePlannification;
	}
	public void setListPlanning(List<TypePlannification> listTypePlannification) {
		this.listTypePlannification = listTypePlannification;
	}
	
}
