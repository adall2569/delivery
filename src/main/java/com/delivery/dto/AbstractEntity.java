package com.delivery.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Where(clause="removed=f")
@MappedSuperclass
public class AbstractEntity {
    @Column(nullable=false, columnDefinition="TEXT default 'admin'")
    private String createdBy;
    @Column(nullable=false)
    private Date createdAt;
    @Column(nullable=false, columnDefinition="TEXT default 'admin'")
    private String updatedBy;
    @Column(nullable=false)
    private Date updatedAt;
    @Column(nullable=false)
    private boolean removed = false;
    
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
       updatedAt = new Date();
    }
}
