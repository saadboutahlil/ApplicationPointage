package com.pointage.backend.rest.DTO;


import java.util.List;

import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.TypePlannification;
public class ListInformationsDTO {
	public List<InformationsDTO> listInfo;
	public List<InformationsDTO> getListCollaborateur() {
		return listInfo;
	}
	
}
