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
    @Autowired
    PaymentService paymentService;

    public WithdrawalRequest sendRequest(WithdrawalRequest request, String secrete){
        if(!confirmSecrete(secrete)){
            return null;
        }
        if (paymentService.checkPayment(request.getTransactionId()) == null){
            return null;
        }
        return withdrawalRequestRepo.save(request);
    }

    private boolean confirmSecrete(String secrete){
        return true;
    }
}
