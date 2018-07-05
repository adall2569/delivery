package com.delivery.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.delivery.dto.DeliveryInfoDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DeliveryInfo extends AbstractEntity {
    @Embedded
    private DeliveryInfoDetail deliveryInfo;
}
