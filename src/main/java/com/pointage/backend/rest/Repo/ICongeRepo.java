package com.pointage.backend.rest.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pointage.backend.rest.Models.Conge;


public interface ICongeRepo extends JpaRepository<Conge,Long>{
}
