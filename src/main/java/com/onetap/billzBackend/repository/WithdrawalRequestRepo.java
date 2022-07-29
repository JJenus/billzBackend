package com.onetap.billzBackend.repository;

import com.onetap.billzBackend.model.WithdrawalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRequestRepo extends JpaRepository<WithdrawalRequest, Long> {
}
