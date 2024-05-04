package com.pointage.backend.rest.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointage.backend.rest.Models.TypePlannification;

public interface ITypePlannificationRepo extends JpaRepository<TypePlannification,Long>{
	 List<TypePlannification> findAllBy();
}
