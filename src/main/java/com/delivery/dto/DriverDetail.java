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
public class DriverDetail extends AbstractEntity {
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @Column(updatable=false, nullable=false)
    @Id private UUID id;
    
    @Column(nullable=false, columnDefinition="TEXT", unique=true)
    private String address;
    @Column(nullable=true, columnDefinition="TEXT")
    private String description;
    @Column(nullable=false, length=15, unique=true)
    private String idNum;
    @Column(nullable=false, length=100)
    private String name;
    @Column(nullable=false, length=255, unique=true)
    private String nickName;
    @Column(nullable=false, length=20, unique=true)
    private String phone;
    @Column(nullable=false, length=100, columnDefinition="int default 0")
    private int recommendedCount;
    @Column(nullable=false, length=100, columnDefinition="int default 0")
    private int reportedCount;
}
