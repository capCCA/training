package com.capgemini.training.services;


import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.PaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListingPaymentDetailsService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public List<PaymentDetailsResponse> listPaymentDetails(){
        
        return paymentRepository.findAll()
                .stream()
                .map( paymentMapper::toPaymentDetailsResponse)
                .toList();
    }


}
