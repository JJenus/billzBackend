package com.onetap.billzBackend.repository;

import com.onetap.billzBackend.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Long> {
}
