package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.PaymentNotFoundException;
import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.model.PaymentRequest;
import com.capgemini.training.api.repository.PaymentRepository;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.model.PaymentEntity;
import com.capgemini.training.api.service.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
Zoimport java.time.ZonedDateTime;
import java.util.Date;

import static java.time.ZoneOffset.UTC;

@Service
@RequiredArgsConstructor
public class UpdatePaymentDetailsService {
    private final PaymentRepository repository;
    private final CustomerDetailsService customerService;
    private final BeneficiaryDetailsService beneficiaryService;

    @Transactional
    public PaymentDetails updatePayment(Long paymentId, PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = repository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment does not exist, can not be updated "));

        // verify customerId and beneficiaryId exists, otherwise they throw exception
        findCustomerById(paymentRequest.getCustomerDetails().getCustomerId());
        findBeneficiaryById(paymentRequest.getBeneficiaryDetails().getBeneficiaryId());

        PaymentMapper.updateEntityFromRequest(paymentEntity, paymentRequest);
        paymentEntity.setUpdateDate(ZonedDateTime.now(UTC));
        return PaymentMapper.toDto(this.repository.save(paymentEntity));
    }

    private CustomerEntity findCustomerById(String customerId) {
        return customerService.findById(customerId);
    }

    private BeneficiaryEntity findBeneficiaryById(String beneficiaryId) {
        return beneficiaryService.findById(beneficiaryId);
    }

}
