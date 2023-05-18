package com.capgemini.training.service;

import java.util.List;

import com.capgemini.training.entity.PaymentEntity;
import org.springframework.stereotype.Service;

import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.mapper.MapperPayment;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPaymentService {

    private final PaymentRepository paymentRepository;

    //public PaymentDto get(Long paymentId) {
        public List<PaymentDto> get(String  customerId) {

            List<PaymentEntity> listPay = this.paymentRepository.findByCustomer_customerId(customerId);
            return listPay.stream().map(MapperPayment::converterDto).toList();
            /*MapperPayment.converterDto()
            return listMarketSegments;

            List<PaymentDto> payList = new ArrayList<PaymentDto>();


            List<PaymentDto> payList = this.accountsService.findByUser(ms.getIdMarketSegment(), username,
                    permisionLevel);



            return List<PaymentDto> paymentRepository
                    .findByCustomerId(customerId)
                    .map(MapperPayment::converterDto).toList()
                .orElseThrow(() -> new UserNotFoundException("payment does not exist in database"));*/

    }

    public List<PaymentDto> findAll() {

        return (List<PaymentDto>) paymentRepository
                .findAll().stream()
                .map(MapperPayment::converterDto).toList();

    }

}