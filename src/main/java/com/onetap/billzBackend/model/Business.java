package com.onetap.billzBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Business {
    private Long id;
    private Long user;
    private  String name;
    private String balance;
    private String currency_code;
    private String country;
    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser owner;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(nullable = false, name = "deleted_at")
    private String deletedAt;

    @PrePersist
    public void onInsert(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
