package com.nikhat.InternalWorkingOfSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component //it create the beans wherever we mention Component tag so there no need of creating object
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorPaymentService implements PaymentService {
    @Override
    public String pay() {
        String payment = "Razorpay Payment";
        System.out.println("payment from :" + payment);
        return payment;
    }
}
