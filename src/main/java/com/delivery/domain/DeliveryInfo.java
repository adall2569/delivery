package com.delivery.domain;

import javax.persistence.Entity;

import com.delivery.dto.DeliveryInfoDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DeliveryInfo extends DeliveryInfoDetail {
    
    public DeliveryInfo update(DeliveryInfoDetail detail) {
        
        this.setDescription(detail.getDescription());
        this.setPayment_method(detail.getPayment_method());
        this.setProductPrice(detail.getProductPrice());

        return this;
    }
}
