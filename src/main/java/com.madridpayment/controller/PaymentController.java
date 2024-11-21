package com.madridpayment.controller;

import com.madridpayment.model.Payment;
import com.madridpayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        payment.setReference(UUID.randomUUID().toString());
        Payment savedPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/retrieve/{reference}")
    public ResponseEntity<?> retrievePayment(@PathVariable String reference) {
        Optional<Payment> payment = paymentRepository.findByReference(reference);
        if (payment.isPresent()) {
            return ResponseEntity.ok(payment.get());
        } else {
            return ResponseEntity.status(404).body("Payment not found");
        }
    }
}
