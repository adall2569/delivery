package com.delivery.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.delivery.domain.AbstractEntity;

import lombok.Data;

@Data
@MappedSuperclass
public class DriverDetailDto extends AbstractEntity {
    @Id
    private Long id;
    @Column(nullable=false, columnDefinition="TEXT", unique=true)
    private String address;
    @Column(nullable=true, columnDefinition="TEXT")
    private String description;
    @Column(nullable=false, length=15, unique=true)
    private String idNum;
    @Column(nullable=false, length=100)
    private String name;
    @Column(nullable=false, length=255)
    private String nickName;
    @Column(nullable=false, length=20, unique=true)
    private String phone;
    @Column(nullable=false, length=100, columnDefinition="int default 0")
    private int recommendedCount;
    @Column(nullable=false, length=100, columnDefinition="int default 0")
    private int reportedCount;
}
