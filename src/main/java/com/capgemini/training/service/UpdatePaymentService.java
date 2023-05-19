package com.capgemini.training.service;

import com.capgemini.training.entity.PaymentEntity;
import com.capgemini.training.exceptions.BeneficiaryNotFoundException;
import com.capgemini.training.exceptions.PaymentNotFoundException;
import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.mapper.MapperPayment;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Params: idPayment and JSON
 *
 * {
 *         "paymentType": "BIZUM",
 *         "amount": 12000.50,
 *         "userDto": {
 *             "customerId": "custom100"
 *         },
 *         "beneficiaryDto": {
 *             "beneficiaryId": "3"
 *         }
 *     }
 *
 */

@RequiredArgsConstructor
@Service
public class UpdatePaymentService {


    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final BeneficiaryRepository beneficiaryRepository;

    public PaymentDto update(Long idPayment , PaymentDto dto) {

        PaymentEntity paymentEntity = paymentRepository.findById(idPayment)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with ID :" + idPayment + " Not Found!"));


        paymentEntity.setCustomer(userRepository.findById(dto.
                        getUserDto().
                        getCustomerId())
                .orElseThrow(() -> new UserNotFoundException("User does not exist in database")));

        paymentEntity.setBeneficiary(beneficiaryRepository.findById(dto
                                .getBeneficiaryDto()
                                .getBeneficiaryId())
                .orElseThrow(() -> new BeneficiaryNotFoundException("Beneficiary does not exist in database")));

        PaymentEntity pEntity = MapperPayment.mapToEntity(dto, paymentEntity);
        paymentRepository.save(pEntity);
        return MapperPayment.converterDto(pEntity);

    }

}
