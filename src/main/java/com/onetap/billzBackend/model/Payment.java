package com.onetap.billzBackend.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_id")
    private String email;
    @Column(name = "trans_id", unique = true)
    private String transactionId;
    @Column(name = "trans_ref", unique = true)
    private String transactionRef;
    private String amount;
    @Column(name = "currency_code")
    private String currencyCode;
    private String status;
//    @OneToOne
//    @JoinColumn(name = "secrete_id")
    private String secrete;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onInsert(){
        if(this.status == null)
            this.status = "pending";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
