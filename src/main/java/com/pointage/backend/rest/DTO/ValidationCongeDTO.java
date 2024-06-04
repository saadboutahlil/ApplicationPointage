package com.pointage.backend.rest.DTO;


public  class ValidationCongeDTO {

    public boolean val;
    public long congeId;

    public ValidationCongeDTO(boolean val, long congeId) {
        this.val = val;
        this.congeId = congeId;
    }
}