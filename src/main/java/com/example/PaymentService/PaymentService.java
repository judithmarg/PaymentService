package com.example.PaymentService;


import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(PaymentRequest paymentRequest) {
        if (!isValidCard(paymentRequest.getCardNumber())) {
            return "Invalid card number";
        }

        if (!isValidCvv(paymentRequest.getCvv())) {
            return "Invalid CVV";
        }

        if (!isValidExpirationDate(paymentRequest.getExpirationDate())) {
            return "Invalid expiration date";
        }

        if (paymentRequest.getAmount() > 1000) {
            return "Payment declined: Amount exceeds limit";
        }

        return "Payment approved: Amount " + paymentRequest.getAmount() + " debited";
    }

    private boolean isValidCard(String cardNumber) {
        return cardNumber != null && cardNumber.length() == 16;
    }

    private boolean isValidCvv(String cvv) {
        return cvv != null && cvv.length() == 3;
    }

    private boolean isValidExpirationDate(String expirationDate) {
        return expirationDate != null && expirationDate.matches("(0[1-9]|1[0-2])/\\d{2}");
    }
}