package com.onetap.billzBackend.repository;

import com.onetap.billzBackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
