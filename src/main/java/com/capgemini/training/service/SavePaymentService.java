package com.capgemini.training.service;


import com.capgemini.training.entity.PaymentEntity;
import com.capgemini.training.exceptions.BeneficiaryNotFoundException;
import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.mapper.MapperPayment;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import com.capgemini.training.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SavePaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final BeneficiaryRepository beneficiaryRepository ;


    public PaymentDto savePayment(PaymentDto paymentDto) {

        PaymentEntity paymentEntity = MapperPayment.converterToEntity(paymentDto);


        paymentEntity.setCustomer(userRepository.findById(paymentDto.
                        getUserDto().
                        getCustomerId())
                        .orElseThrow(() -> new UserNotFoundException("User does not exist in database")));

        paymentEntity.setBeneficiary(beneficiaryRepository.findById(paymentDto
                .getBeneficiaryDto()
                .getBeneficiaryId())
                .orElseThrow(() -> new BeneficiaryNotFoundException("Beneficiary does not exist in database")));

        PaymentEntity save = paymentRepository.save(paymentEntity);
        return MapperPayment.converterDto(save);

    }

}