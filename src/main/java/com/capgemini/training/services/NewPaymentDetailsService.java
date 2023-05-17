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
public class NewPaymentDetailsService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentDetailsResponse createNewPayment(PaymentDetailsRequest paymentDetailsRequest){


        if( paymentRepository.existsById( paymentDetailsRequest.getPaymentId() )){
            throw new PaymentDetailsException("El pago ya se encuentra registrado");
        }

        return Optional.of(paymentRepository.save( paymentMapper.toEntityFromRequest(paymentDetailsRequest) ))
                    .map( paymentMapper::toPaymentDetails )
                    .orElseThrow( ()-> new PaymentDetailsException("Error al intentar guardar el pago en la base de datos") );

    }
}
