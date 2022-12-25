package com.saga.PaymentService.repository;

import com.saga.PaymentService.command.api.data.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String> {
}
