package com.onetap.billzBackend.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class WithdrawalRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "trans_id")
    private String transactionId;
    @Column(name = "user_id")
    private String userId;

    @Column(name = "withdrawal_method", nullable = false)
    private String withdrawalMethod;
    private String amount;
    @Column(name = "currency_code", nullable = false)
    private String currencyCode;
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    private WithdrawalMethod destination;

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
