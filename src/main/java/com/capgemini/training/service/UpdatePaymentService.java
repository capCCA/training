package com.capgemini.training.service;

import com.capgemini.training.entity.PaymentEntity;
import com.capgemini.training.mapper.MapperPayment;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author ezorzome
 * @descriprion Service to update User
 *
 */

@RequiredArgsConstructor
@Service
public class UpdatePaymentService {

    private final PaymentRepository paymentRepository;

    public UserDto update(Long idPayment , PaymentDto dto) {

       /* PaymentEntity paymentEntity = paymentRepository.findById(idPayment)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with ID :" + idPayment + " Not Found!"));
        MapperPayment.mapToEntity(dto, paymentEntity);
        paymentRepository.save(paymentEntity);

        return dto;*/
        return null;

    }

}
