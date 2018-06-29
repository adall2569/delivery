package com.delivery.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.delivery.domain.constants.DeliveryLifeCycle;
import com.delivery.domain.constants.PaymentMethod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DeliveryInfo extends AbstractEntity {
    @Id
    private Long id;
    private Long driverId;
    private Long storeId;
    @Column(nullable=true, columnDefinition="TEXT")
    private String description;
    @Column(nullable=false)
    private Long distance;
    @Column(nullable=false)
    private Long deliveryPrice;
    @Column(nullable=false)
    private Long productPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;
    private Date pickup_time;
    @Column(nullable=false, columnDefinition="TEXT")
    private String targetAddress;
    @Enumerated(EnumType.STRING)
    private DeliveryLifeCycle status;
}
