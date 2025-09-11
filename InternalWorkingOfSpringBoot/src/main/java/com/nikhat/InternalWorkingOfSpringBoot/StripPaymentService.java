package com.nikhat.InternalWorkingOfSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "strip")
public class StripPaymentService implements PaymentService {
    @Override
    public String pay() {
        String payment = "Strip Payment";
        System.out.println("payment from :" + payment);
        return payment;
    }
}
