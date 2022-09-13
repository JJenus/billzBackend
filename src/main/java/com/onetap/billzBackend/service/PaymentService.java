package com.onetap.billzBackend.service;

import com.onetap.billzBackend.model.Payment;
import com.onetap.billzBackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment){
        if (payment.getId() != null)
            return null;
        return paymentRepository.save(payment);
    }

    public Payment checkPayment(String trId) {
        Optional<Payment> optionalPayment = paymentRepository.findByTransactionId(trId);
        if (optionalPayment.isPresent())
            return optionalPayment.get();
        return null;
    }
}
