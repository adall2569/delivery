package com.delivery.domain;

import javax.persistence.Entity;

import com.delivery.dto.StoreDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Store extends StoreDetail {
    
    public Store update(StoreDetail detail) {
        this.setAddress(detail.getAddress());
        this.setName(detail.getName());
        this.setStoreName(detail.getStoreName());
        
        return this;
    }
}
