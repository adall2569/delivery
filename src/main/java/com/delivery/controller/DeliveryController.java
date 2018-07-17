package com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.domain.DeliveryInfo;
import com.delivery.dto.DeliveryInfoDetail;
import com.delivery.dto.ResponseData;
import com.delivery.service.DeliveryService;

@RestController
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    
    @RequestMapping(value = "/delivery", method = RequestMethod.POST, produces = "application/json")
    public ResponseData createDriver(
            @RequestBody DeliveryInfoDetail detail) {
        
        DeliveryInfoDetail savedDetail = deliveryService.createDeliveryInfo(detail);
        
        return new ResponseData(savedDetail);
    }
    
    @RequestMapping(value = "/delivery/{id}", method = RequestMethod.PATCH, produces = "application/json")
    public ResponseData patchDriver(
            @PathVariable(value = "id") Long id,
            @RequestBody DeliveryInfoDetail detail) {
        
        DeliveryInfoDetail savedDetail = deliveryService.patchDeliveryInfo(id, detail);
        return new ResponseData(savedDetail);
    }
    
    @RequestMapping(value = "/delivery/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getDriver(
            @PathVariable(value = "id") Long id) {
        
        DeliveryInfo store = deliveryService.getDeliveryInfo(id);
        return new ResponseData(store);
    }
}
