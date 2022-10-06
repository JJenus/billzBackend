package com.onetap.billzBackend.controller;

import com.onetap.billzBackend.model.Payment;
import com.onetap.billzBackend.model.PaymentMethod;
import com.onetap.billzBackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment){
        System.out.println(payment.getAmount());
        return ResponseEntity.status(HttpStatus.CREATED).body(
                paymentService.savePayment(payment)
        );
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkPayment(@RequestBody Map<String, String> req){
        Payment payment = paymentService.checkPayment(req.get("trans_id"));
        if (payment == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    this.errorResponse("Transaction id not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    @GetMapping("/methods")
    public ResponseEntity<?> paymentMethods(){
        List<PaymentMethod> paymentMethods = paymentService.getPaymentMethods();
        if (paymentMethods.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    this.errorResponse("No payment methods found"));
        }
        return ResponseEntity.ok(paymentMethods);
    }

    @PostMapping("/methods")
    public PaymentMethod paymentMethod(@RequestBody PaymentMethod paymentMethod){
        return paymentService.savePaymentMethod(paymentMethod);
    }

    private Map<String, String> errorResponse(String res){
        Map<String, String> message = new HashMap<>(2);
        message.put("status", ""+HttpStatus.NOT_FOUND.value());
        message.put("error", res);
        return message;
    }
}
