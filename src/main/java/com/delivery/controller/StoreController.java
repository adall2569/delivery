package com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.domain.Store;
import com.delivery.dto.ResponseData;
import com.delivery.dto.StoreDetail;
import com.delivery.service.StoreService;

@RestController
@RequestMapping("/api/v1")
public class StoreController {
    @Autowired
    private StoreService storeService;
    
    @RequestMapping(value = "/store", method = RequestMethod.POST, produces = "application/json")
    public ResponseData createStore(
            @RequestBody StoreDetail detail) {
        
        StoreDetail savedDetail = storeService.createStore(detail);
        return new ResponseData(savedDetail);
    }
    
    @RequestMapping(value = "/store/{id}", method = RequestMethod.PATCH, produces = "application/json")
    public ResponseData patchStore(
            @PathVariable(value = "id") String id,
            @RequestBody StoreDetail detail) {
        
        StoreDetail savedDetail = storeService.patchStore(id, detail);
        return new ResponseData(savedDetail);
    }
    
    @RequestMapping(value = "/store/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getStore(
            @PathVariable(value = "id") String id) {
        
        Store store = storeService.getStore(id);
        return new ResponseData(store);
    }
}
