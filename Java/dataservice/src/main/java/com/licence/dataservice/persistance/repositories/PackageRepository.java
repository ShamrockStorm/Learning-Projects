package com.licence.dataservice.persistance.repositories;

import com.licence.dataservice.persistance.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageEntity,Integer> {
}
