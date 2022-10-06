package com.onetap.billzBackend.controller;

import com.onetap.billzBackend.model.WithdrawalMethod;
import com.onetap.billzBackend.model.WithdrawalRequest;
import com.onetap.billzBackend.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("withdraw")
public class Withdrawal {
    @Autowired
    WithdrawalService withdrawalService;

    public ResponseEntity<?> requestWithdrawal(@RequestBody Map<String, String> form){
        WithdrawalRequest request = new WithdrawalRequest();
        if(form.get("address") == null || form.get("trans_id") == null){
            return ResponseEntity.ok(this.errorResponse("Destination address and transaction id is required"));
        }
        request.setTransactionId(form.get("trans_id"));
        request.setAmount(form.get("amount"));
        request.setCurrencyCode(form.get("currency_code"));
        request.setStatus("pending");

        WithdrawalMethod method = new WithdrawalMethod();
        method.setMethod(form.get("method"));
        method.setAddress(form.get("address"));
        method.setName(form.get("name"));
        request.setWithdrawalMethod(method);
        String secrete = form.get("secrete");

        if (withdrawalService.sendRequest(request, secrete) != null){
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(401).body(errorResponse("wrong secrete"));
    }

    private Map<String, String> errorResponse(String res){
        Map<String, String> message = new HashMap<>(2);
        message.put("status", ""+ HttpStatus.NOT_FOUND.value());
        message.put("error", res);
        return message;
    }
}
