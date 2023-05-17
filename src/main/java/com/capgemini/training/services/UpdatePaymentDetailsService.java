package com.capgemini.training.services;

import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdatePaymentDetailsService {

    private PaymentRepository paymentRepository;
    private PaymentMapper paymentMapper;

    public PaymentDetailsResponse updatePayment(PaymentDetailsRequest paymentDetailsRequest){

        return  Optional.of(paymentRepository.save( paymentMapper.toEntityFromRequest(paymentDetailsRequest) ))
                    .map( paymentMapper::toPaymentDetails )
                    .orElseThrow( ()-> new PaymentDetailsException("Error al intentar actualizar el pago"));

    }
}
