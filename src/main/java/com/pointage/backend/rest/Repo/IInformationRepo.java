package com.pointage.backend.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pointage.backend.rest.Models.Information;

public interface IInformationRepo extends JpaRepository<Information,Long>{
}
