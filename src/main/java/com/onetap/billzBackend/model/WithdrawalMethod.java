package com.onetap.billzBackend.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class WithdrawalMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String method;
    private String name;
    private String address;
}
