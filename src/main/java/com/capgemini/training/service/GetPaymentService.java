package com.capgemini.training.service;

import java.util.List;

import com.capgemini.training.entity.PaymentEntity;
import com.capgemini.training.exceptions.PaymentNotFoundException;
import org.springframework.stereotype.Service;
import com.capgemini.training.mapper.MapperPayment;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPaymentService {

    private final PaymentRepository paymentRepository;

        public List<PaymentDto> get(String  customerId) {

            List<PaymentEntity> listPay = this.paymentRepository.findByCustomer_customerId(customerId);
            return listPay.stream().map(MapperPayment::converterDto).toList();

    }

    public List<PaymentDto> findAll() {

        return paymentRepository
                .findAll().stream()
                .map(MapperPayment::converterDto).toList();

    }

}