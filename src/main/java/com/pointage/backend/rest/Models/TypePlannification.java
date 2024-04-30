package com.pointage.backend.rest.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypePlannification {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long typePlannificationId;
    
    @Column
    public String type;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="typePlannification")
    private List<Planning> planning;

    // Default constructor
    public TypePlannification() {
        // Initialize planning list
        this.planning = new ArrayList<>();
    }

    // Constructor with parameters
    public TypePlannification(long typePlannificationId, String type) {
        this.typePlannificationId = typePlannificationId;
        this.type = type;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTypePlannificationId() {
        return typePlannificationId;
    }

    public void setTypePlannificationId(long typePlannificationId) {
        this.typePlannificationId = typePlannificationId;
    }

    public List<Planning> getPlanning() {
        return planning;
    }

    public void setPlanning(List<Planning> planning) {
        this.planning = planning;
    }
    /*
    // Initialize predefined types of planning
    public static final TypePlannification TELETRAVAIL = new TypePlannification(1, "TT"); // teletravail
    public static final TypePlannification PRESENTIEL = new TypePlannification(2, "PR"); // presentiel
    public static final TypePlannification CONGE = new TypePlannification(3, "CO"); // congé
    */
}
