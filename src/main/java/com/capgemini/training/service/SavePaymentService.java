package com.capgemini.training.service;

import com.capgemini.training.entity.PaymentEntity;
import com.capgemini.training.exceptions.PaymentBadRequestException;
import com.capgemini.training.mapper.MapperPayment;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.exceptions.UserBadRequestException;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SavePaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    public PaymentDto savePayment(PaymentDto paymentDto) {

        PaymentEntity paymentEntity = MapperPayment.converterToEntity(paymentDto);


        /*if (paymentRepository.existsById(paymentDto.getPaymentId())) {
            throw new PaymentBadRequestException("This idPayment exits");
        }*/
        //paimentEntity.setcustomer(userRepositri.findbycustomerID

        paymentEntity.setCustomer(userRepository.findById(paymentDto.getUserDto().getCustomerId()).orElse(null));
        PaymentEntity save = paymentRepository.save(paymentEntity);
        PaymentDto paymentDto1 = MapperPayment.converterDto(save);
        return paymentDto1;

    }

}