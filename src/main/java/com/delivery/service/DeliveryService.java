package com.delivery.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.domain.DeliveryInfo;
import com.delivery.domain.repository.DeliveryInfoRepository;
import com.delivery.dto.DeliveryInfoDetail;
import com.delivery.exception.CatalogException;
import com.delivery.exception.ErrorCode;

public class DeliveryService {
    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Transactional
    public DeliveryInfoDetail createDeliveryInfo(DeliveryInfoDetail detail) {
        DeliveryInfo deliveryInfo = mapper.map(detail, DeliveryInfo.class);
        
        DeliveryInfo savedDeliveryInfo = deliveryInfoRepository.save(deliveryInfo);
        
        return savedDeliveryInfo;
    }
    
    @Transactional
    public DeliveryInfoDetail patchDeliveryInfo(Long id, DeliveryInfoDetail detail) {
        Optional<DeliveryInfo> oDeliveryInfo = deliveryInfoRepository.findById(id);
        if (!oDeliveryInfo.isPresent()) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DELIVERY);
        }
        
        DeliveryInfo deliveryInfo = oDeliveryInfo.get();
        deliveryInfo.update(detail);
        
        return deliveryInfo;
    }
    
    @Transactional(readOnly=true)
    public DeliveryInfo getDeliveryInfo(Long id) {
        Optional<DeliveryInfo> oDeliveryInfo = deliveryInfoRepository.findById(id);
        if (!oDeliveryInfo.isPresent()) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DELIVERY);
        }
        
        return oDeliveryInfo.get();
    }
    
    @Transactional
    public void deleteDeliveryInfo(Long id) {
        Optional<DeliveryInfo> oDeliveryInfo = deliveryInfoRepository.findById(id);
        if (!oDeliveryInfo.isPresent()) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DELIVERY);
        }
        
        DeliveryInfo deliveryInfo = oDeliveryInfo.get();
        deliveryInfo.setRemoved(true);
    }
    
    private void validateCreate(DeliveryInfoDetail detail) {
//        if (detail.get) {
//            throw new CatalogException(ErrorCode.CANNOT_FIND_DELIVERY);
//        }
    }
    
    private void validateUpdate(Long id, DeliveryInfoDetail detail) {
        if (!deliveryInfoRepository.existsById(id)) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DELIVERY);
        }
    }
    
    private void validateDelete(Long id) {
        if (!deliveryInfoRepository.existsById(id)) {
            throw new CatalogException(ErrorCode.CANNOT_FIND_DELIVERY);
        }
    }
}

