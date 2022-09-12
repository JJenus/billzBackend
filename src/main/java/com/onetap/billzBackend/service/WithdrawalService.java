package com.onetap.billzBackend.service;

import com.onetap.billzBackend.model.WithdrawalRequest;
import com.onetap.billzBackend.repository.WithdrawalMethodRepo;
import com.onetap.billzBackend.repository.WithdrawalRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {
    @Autowired
    WithdrawalRequestRepo withdrawalRequestRepo;
    @Autowired
    WithdrawalMethodRepo withdrawalMethodRepo;

    public WithdrawalRequest sendRequest(WithdrawalRequest request){
        return withdrawalRequestRepo.save(request);
    }
}
