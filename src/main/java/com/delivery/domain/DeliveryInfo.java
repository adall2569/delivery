package com.delivery.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DeliveryInfo extends AbstractEntity {
    @Embedded
    private DeliveryInfoDetail deliveryInfo;
}
