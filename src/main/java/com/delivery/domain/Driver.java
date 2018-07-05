package com.delivery.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.delivery.dto.DriverDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Driver extends AbstractEntity {
    @Embedded
    private DriverDetail driver;
}
