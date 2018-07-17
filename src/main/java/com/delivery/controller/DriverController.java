package com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.domain.Driver;
import com.delivery.dto.DriverDetail;
import com.delivery.dto.ResponseData;
import com.delivery.service.DriverService;

@RestController
@RequestMapping("/api/v1")
public class DriverController {
    @Autowired
    private DriverService driverService;
    
    @RequestMapping(value = "/driver", method = RequestMethod.POST, produces = "application/json")
    public ResponseData createDriver(
            @RequestBody DriverDetail detail) {
        
        DriverDetail savedDetail = driverService.createDriver(detail);
        return new ResponseData(savedDetail);
    }
    
    @RequestMapping(value = "/driver/{id}", method = RequestMethod.PATCH, produces = "application/json")
    public ResponseData patchDriver(
            @PathVariable(value = "id") String id,
            @RequestBody DriverDetail detail) {
        
        DriverDetail savedDetail = driverService.patchDriver(id, detail);
        return new ResponseData(savedDetail);
    }
    
    @RequestMapping(value = "/driver/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getDriver(
            @PathVariable(value = "id") String id) {
        
        Driver store = driverService.getDriver(id);
        return new ResponseData(store);
    }
}
