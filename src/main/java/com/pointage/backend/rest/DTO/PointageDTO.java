package com.pointage.backend.rest.DTO;


public  class PointageDTO {

    public boolean badge;
    public long collaborateurId;

    public PointageDTO(boolean badge, long collaborateurId) {
        this.badge = badge;
        this.collaborateurId = collaborateurId;
    }
}