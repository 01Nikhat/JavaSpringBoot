package com.nikhat.InternalWorkingOfSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingOfSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {

        SpringApplication.run(InternalWorkingOfSpringBootApplication.class, args);
	}



    // first way is field way injection using @Autowired annotation
    //this annotation tells to frmaework creating object for the class and need dependency
    // here we cannot use final keayword like private final RazorPaymentService paymentService;
   // @Autowired
    private final PaymentService paymentService;

    // there are second way is make constructor and pass the function object as an argument
    public InternalWorkingOfSpringBootApplication(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        String payment = paymentService.pay();
        System.out.println("Payment done :" +payment);
    }
}
