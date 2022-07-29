package com.onetap.billzBackend.repository;

import com.onetap.billzBackend.model.WithdrawalMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalMethodRepo extends JpaRepository<WithdrawalMethod, Long> {
}
