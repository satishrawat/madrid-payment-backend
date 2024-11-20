package com.madridpayment.repository;

import com.madridpayment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByReference(String reference);
}

