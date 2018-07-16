package com.delivery.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.domain.Driver;
import com.delivery.domain.repository.DriverRepository;
import com.delivery.dto.DriverDetail;
import com.delivery.exception.CatalogException;
import com.delivery.exception.ErrorCode;

public class DriverService {
    @Autowired
    private DriverRepository driverRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Transactional
    public DriverDetail createDriver(DriverDetail detail) {
        validateCreate(detail);
        
        Driver driver = mapper.map(detail, Driver.class);
        
        Driver savedDriver = driverRepository.save(driver);
        
        return savedDriver;
    }
    
    @Transactional
    public DriverDetail patchDriver(String id, DriverDetail detail) {
        validateUpdate(id, detail);
        
        Optional<Driver> oDriver = driverRepository.findById(UUID.fromString(id));
        
        Driver driver = oDriver.get();
        driver.update(detail);
        
        return driver;
    }
    
    @Transactional(readOnly=true)
    public Driver getDriver(String id) {
        Optional<Driver> oDriver = driverRepository.findById(UUID.fromString(id));
        if (!oDriver.isPresent()) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DRIVER);
        }
        
        return oDriver.get();
    }
    
    @Transactional
    public void deleteDriver(String id) {
        validateDelete(id);
        
        Optional<Driver> oDriver = driverRepository.findById(UUID.fromString(id));
        Driver driver = oDriver.get();
        
        driver.setRemoved(true);
    }
    
    private void validateCreate(DriverDetail detail) {
        if (driverRepository.existsByAddress(detail.getAddress())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_ADDRESS);
        }
        
        if (driverRepository.existsByIdNum(detail.getIdNum())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_ID_NUM);
        }
        
        if (driverRepository.existsByNickName(detail.getNickName())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_NICK_NAME);
        }
        
        if (driverRepository.existsByPhone(detail.getPhone())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_PHONE);
        }
    }
    
    private void validateUpdate(String id, DriverDetail detail) {
        if (!driverRepository.existsById(UUID.fromString(id))) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DRIVER);
        }
        
        if (driverRepository.existsByAddress(detail.getAddress())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_ADDRESS);
        }
        
        if (driverRepository.existsByIdNum(detail.getIdNum())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_ID_NUM);
        }
        
        if (driverRepository.existsByNickName(detail.getNickName())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_NICK_NAME);
        }
        
        if (driverRepository.existsByPhone(detail.getPhone())) {
            throw new CatalogException(ErrorCode.DRIVER_CONFLICT_PHONE);
        }
    }
    
    private void validateDelete(String id) {
        if (!driverRepository.existsById(UUID.fromString(id))) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DRIVER);
        }
    }
}
