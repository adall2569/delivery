package com.delivery.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.delivery.dto.StoreDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Store extends AbstractEntity {
    @Embedded
    private StoreDetail store;
}
