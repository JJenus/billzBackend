package com.onetap.billzBackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class WithdrawalMethod {
    private Long id;
    private String name;
    @Column(name = "withdrawal_id")
    private String withdrawalId;
    @Column(name = "destination_id")
    private Long destinationId;
}
