package com.example.PaymentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService();
    }

    @Test
    void testProcessPaymentWithValidDetails() {
        PaymentRequest validRequest = new PaymentRequest("1234567812345678", "123", "12/25", 500);

        String result = paymentService.processPayment(validRequest);

        assertEquals("Payment approved: Amount 500.0 debited", result);
    }

    @Test
    void testProcessPaymentWithInvalidCardNumber() {
        PaymentRequest invalidCardRequest = new PaymentRequest("123", "123", "12/25", 500);

        String result = paymentService.processPayment(invalidCardRequest);

        assertEquals("Invalid card number", result);
    }

    @Test
    void testProcessPaymentWithInvalidCvv() {
        PaymentRequest invalidCvvRequest = new PaymentRequest("1234567812345678", "12", "12/25", 500);

        String result = paymentService.processPayment(invalidCvvRequest);

        assertEquals("Invalid CVV", result);
    }

    @Test
    void testProcessPaymentWithInvalidExpirationDate() {
        PaymentRequest invalidDateRequest = new PaymentRequest("1234567812345678", "123", "13/25", 500);

        String result = paymentService.processPayment(invalidDateRequest);

        assertEquals("Invalid expiration date", result);
    }

    @Test
    void testProcessPaymentWithAmountExceedingLimit() {
        PaymentRequest exceedingAmountRequest = new PaymentRequest("1234567812345678", "123", "12/25", 1500);

        String result = paymentService.processPayment(exceedingAmountRequest);

        assertEquals("Payment declined: Amount exceeds limit", result);
    }
}