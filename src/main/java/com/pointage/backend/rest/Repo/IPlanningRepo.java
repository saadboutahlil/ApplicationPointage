package com.pointage.backend.rest.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointage.backend.rest.Models.Planning;

public interface IPlanningRepo extends JpaRepository<Planning,Long>{
    List<Planning> findByCollaborateur_UtilisateurId(long collaborateurId);
}
