package com.delivery.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
    Optional<Driver> findById(UUID id);
    
//    boolean existsById(UUID id);
    boolean existsByAddress(String address);
    boolean existsByIdNum(String idNum);
    boolean existsByNickName(String nickName);
    boolean existsByPhone(String phone);
}
