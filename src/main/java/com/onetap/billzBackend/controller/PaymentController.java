package com.onetap.billzBackend.controller;

import com.onetap.billzBackend.model.Payment;
import com.onetap.billzBackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> checkPayment(@RequestBody Map<String, String> req){
        Payment payment = paymentService.checkPayment(req.get("transaction_id"));
        if (payment == null){
            Map<String, String> message = new HashMap<>(2);
            message.put("status", ""+HttpStatus.OK);
            message.put("error", "Transaction id not found");
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }
}
