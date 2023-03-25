package com.multiple.datasource.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.datasource.entity.payment.PaymentDetails;

public interface PaymentRepository extends JpaRepository<PaymentDetails, Long>{

}
