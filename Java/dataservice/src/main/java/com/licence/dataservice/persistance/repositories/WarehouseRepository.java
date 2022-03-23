package com.licence.dataservice.persistance.repositories;

import com.licence.dataservice.persistance.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity,Integer> {
}
