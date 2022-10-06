package com.onetap.billzBackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Secrete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String secrete;
    @OneToOne
    @JoinColumn(name = "location_lock_id")
    private LocationLock locationLock;
}
