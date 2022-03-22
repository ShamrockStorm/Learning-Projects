package com.licence.dataservice.persistance.repositories;

import com.licence.dataservice.persistance.entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity,Integer> {
}
