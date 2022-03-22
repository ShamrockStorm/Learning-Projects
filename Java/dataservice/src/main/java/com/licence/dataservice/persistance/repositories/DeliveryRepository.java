package com.licence.dataservice.persistance.repositories;

import com.licence.dataservice.persistance.entities.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity,Integer> {
}
