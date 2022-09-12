package com.onetap.billzBackend.controller;

import com.onetap.billzBackend.model.Payment;
import com.onetap.billzBackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> makePayment(Payment payment){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                paymentService.makePayment(payment)
        );
    }

    @PostMapping("/check")
    public ResponseEntity<PaymentController> checkPayment(@RequestParam("tr_id") String trId){
        return null;
    }
}
