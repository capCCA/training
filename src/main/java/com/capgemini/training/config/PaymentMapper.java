package com.capgemini.training.config;

import com.capgemini.training.dto.PaymentDto;
import com.capgemini.training.entity.Payment;

public final class PaymentMapper {
    public static Payment toEntity(PaymentDto dto) {
        return Payment.builder().paymentId(dto.getPaymentId()).customerId(dto.getCustomerId())
                .beneficiaryId(dto.getBeneficiaryId()).paymentType(dto.getPaymentType()).amount(dto.getAmount())
                .build();
    }

    public static PaymentDto toDto(Payment payment) {
        return PaymentDto.builder().paymentId(payment.getPaymentId()).customerId(payment.getCustomerId())
                .beneficiaryId(payment.getBeneficiaryId()).paymentType(payment.getPaymentType())
                .amount(payment.getAmount()).build();
    }
}