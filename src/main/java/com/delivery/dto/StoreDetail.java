package com.delivery.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class StoreDetail {
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @Column(updatable=false, nullable=false)
    @Id private UUID id;
    
    @Column(nullable=false, unique=true, columnDefinition="TEXT")
    private String address;
    @Column(nullable=false, length=255)
    private String name;
    @Column(nullable=false, length=255)
    private String store_name;
}
