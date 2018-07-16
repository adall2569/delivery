package com.delivery.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.domain.Store;
import com.delivery.domain.repository.StoreRepository;
import com.delivery.dto.StoreDetail;
import com.delivery.exception.CatalogException;
import com.delivery.exception.ErrorCode;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Transactional
    public StoreDetail createStore(StoreDetail detail) {
        validateCreate(detail);
        
        Store store = mapper.map(detail, Store.class);
        
        Store savedStore = storeRepository.save(store);
        
        return savedStore;
    }
    
    @Transactional
    public StoreDetail patchStore(String id, StoreDetail detail) {
        validateUpdate(detail);
        
        Optional<Store> oStore = storeRepository.findById(UUID.fromString(id));
        if (!oStore.isPresent()) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_STORE);
        }
        
        Store store = oStore.get();
        store.update(detail);
        
        return store;
    }
    
    @Transactional(readOnly=true)
    public Store getStore(String id) {
        Optional<Store> oStore = storeRepository.findById(UUID.fromString(id));
        if (!oStore.isPresent()) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_STORE);
        }
        
        return oStore.get();
    }
    
    @Transactional
    public void deleteStore(String id) {
        Optional<Store> oStore = storeRepository.findById(UUID.fromString(id));
        if (!oStore.isPresent()) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_STORE);
        }
        
        Store store = oStore.get();
        store.setRemoved(true);
    }
    
    private void validateCreate(StoreDetail detail) {
        Store store = storeRepository.findByAddress(detail.getAddress());
        if (store != null) {
            throw new CatalogException(ErrorCode.STORE_CONFLICT_ADDRESS);
        }
    }
    
    private void validateUpdate(StoreDetail detail) {
        Store store = storeRepository.findByAddress(detail.getAddress());
        if (store != null) {
            throw new CatalogException(ErrorCode.STORE_CONFLICT_ADDRESS);
        }
    }
}
