package com.example.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController implements PaymentApi{

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(@RequestParam PaymentRequest paymentRequest) {
        String res = paymentService.processPayment(paymentRequest);
        PaymentResponse response = new PaymentResponse(res);
        return ResponseEntity.ok(response);
    }
}
