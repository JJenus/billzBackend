package com.onetap.billzBackend.service;

import com.onetap.billzBackend.model.Payment;
import com.onetap.billzBackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment){
        return paymentRepository.save(payment);
    }
}
