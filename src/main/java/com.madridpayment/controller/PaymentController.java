package com.madridpayment.controller;

import com.madridpayment.model.Payment;
import com.madridpayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @PostMapping
    public String createPayment(@RequestBody Payment payment) {
        String reference = UUID.randomUUID().toString();
        payment.setReference(reference);
        repository.save(payment);
        return "Payment created with reference: " + reference;
    }

    @GetMapping("/{reference}")
    public Payment getPaymentByReference(@PathVariable String reference) {
        return repository.findByReference(reference);
    }
}

