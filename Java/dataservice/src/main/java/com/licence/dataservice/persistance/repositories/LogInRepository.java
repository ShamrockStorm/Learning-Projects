package com.licence.dataservice.persistance.repositories;

import com.licence.dataservice.persistance.entities.LogInEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInRepository extends JpaRepository<LogInEntity,Integer> {
}
