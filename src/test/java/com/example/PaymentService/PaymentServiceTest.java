package com.example.PaymentService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void processPayment() {
        PaymentService paymentService = new PaymentService();
        PaymentRequest paymentRequest= new PaymentRequest("","","",2.3);
        assertNotNull(paymentService.processPayment(paymentRequest));
    }
}