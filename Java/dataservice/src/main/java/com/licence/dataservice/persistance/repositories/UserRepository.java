package com.licence.dataservice.persistance.repositories;

import com.licence.dataservice.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
