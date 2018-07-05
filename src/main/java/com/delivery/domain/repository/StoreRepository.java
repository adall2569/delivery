package com.delivery.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findById(UUID id); 
}
