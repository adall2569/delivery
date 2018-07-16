package com.delivery.domain;

import javax.persistence.Entity;

import com.delivery.dto.DriverDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Driver extends DriverDetail {
    
    public Driver update(DriverDetail detail) {
        this.setAddress(detail.getAddress());
        this.setDescription(detail.getDescription());
        this.setName(detail.getName());
        this.setNickName(detail.getNickName());
        this.setPhone(detail.getPhone());
        
        return this;
    }
}
