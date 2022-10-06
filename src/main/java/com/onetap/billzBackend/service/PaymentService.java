package com.onetap.billzBackend.service;

import com.onetap.billzBackend.model.Payment;
import com.onetap.billzBackend.model.PaymentMethod;
import com.onetap.billzBackend.repository.PaymentMethodRepo;
import com.onetap.billzBackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentMethodRepo paymentMethodRepo;

    public PaymentMethod savePaymentMethod(PaymentMethod method){
        return paymentMethodRepo.save(method);
    }
    public List<PaymentMethod> getPaymentMethods(){
        return paymentMethodRepo.findAll();
    }
    public Payment savePayment(Payment payment){
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

    public String generateId(String email, String amount1, String secrete) {
        return "";
    }

    // Use code to set expiry date
//    Calendar c = Calendar.getInstance();
//        c.add(Calendar.MINUTE, 20);
//    Date d = c.getTime();
//    SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
//    String newStopTime = datetime.format(d);
//        System.out.println(newStopTime);
}
