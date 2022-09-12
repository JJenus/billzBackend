package com.onetap.billzBackend.controller;

import com.onetap.billzBackend.model.WithdrawalMethod;
import com.onetap.billzBackend.model.WithdrawalRequest;
import com.onetap.billzBackend.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("withdraw")
public class Withdrawal {
    @Autowired
    WithdrawalService withdrawalService;

    public ResponseEntity<?> requestWithdrawal(@RequestBody Map<String, String> form){
        WithdrawalRequest request = new WithdrawalRequest();
        if(form.get("withdrawal_method") == null || form.get("trans_id") == null){
            throw new IllegalStateException("Transaction id and withdrawal method must be available");
        }
        request.setTransactionId(form.get("trans_id"));
        request.setUserId(form.getOrDefault("user_id", request.getTransactionId()));
        request.setWithdrawalMethod(form.get("withdrawal_method"));
        request.setAmount(form.get("amount"));
        request.setCurrencyCode(form.get("currency_code"));
        request.setStatus("pending");

        WithdrawalMethod method = new WithdrawalMethod();
        method.setMethod(form.get("method"));
        method.setDestinationId(form.get("destination"));
        method.setWithdrawalId("withdrawal_id");

        request.setDestination(method);

        return ResponseEntity.ok(withdrawalService.sendRequest(request));
    }
}
