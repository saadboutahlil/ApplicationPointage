package com.pointage.backend.rest.Repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointage.backend.rest.Models.Collaborateur;
import com.pointage.backend.rest.Models.Pointage;

public interface IPointageRepo extends JpaRepository<Pointage,Long>{
	 List<Pointage> findByCollaborateurOrderByDatePointageDesc(Collaborateur collaborateur);
	 Optional<Pointage> findFirstByCollaborateurOrderByDatePointageDesc(Collaborateur collaborateur);
}
