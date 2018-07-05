package com.delivery.service;

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
        StoreDetail storeDetail = mapper.map(detail, StoreDetail.class);
        
        Store store = new Store();
        store.setStore(storeDetail);
        
        Store savedStore = storeRepository.save(store);
        
        return savedStore.getStore();
    }
    
    @Transactional
    public StoreDetail patchStore(String id, StoreDetail detail) {
        Store store = storeRepository.findById(UUID.fromString(id));
        if (store == null) {
            throw new CatalogException(ErrorCode.CATALOG_CANNOT_FIND_STORE);
        }
        store.setStore(detail);
        
        return detail;
    }
    
    @Transactional(readOnly=true)
    public Store getStore(String id) {
        Store store = storeRepository.findById(UUID.fromString(id));
        if (store == null) {
            throw new CatalogException(ErrorCode.CATALOG_CANNOT_FIND_STORE);
        }
        
        return store;
    }
}
