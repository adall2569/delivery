package com.delivery.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@MappedSuperclass
public class StoreDetail extends AbstractEntity {
    
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @Column(updatable=false, nullable=false)
    @Id private UUID id;
    
    @Column(nullable=false, unique=true, columnDefinition="TEXT")
    private String address;
    @Column(nullable=false, length=255)
    private String name;
    @Column(name="store_name", nullable=false, length=255)
    private String storeName;
}
