package com.capgemini.training.api.service.mapper;

import com.capgemini.training.api.model.BeneficiaryDetails;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.model.UpdatePaymentRequest;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.model.PaymentEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {

    public  PaymentEntity toEntity(PaymentDetails dto) {
        CustomerEntity customer = CustomerMapper.toEntity(dto.getCustomerDetails());
        BeneficiaryEntity ben = BeneficiaryMapper.toEntity(dto.getBeneficiaryDetails());

        return PaymentEntity.builder().paymentId(dto.getPaymentId()).customer(customer).beneficiary(ben)
                .paymentType(dto.getPaymentType()).amount(dto.getAmount()).build();
    }

    // added: no ppaymentID
    public static void updateEntityFromRequest(PaymentEntity entity, UpdatePaymentRequest paymentRequest) {
        CustomerEntity customer = CustomerMapper.toEntity(paymentRequest.getCustomerDetails());
        BeneficiaryEntity ben = BeneficiaryMapper.toEntity(paymentRequest.getBeneficiaryDetails());
        entity.setCustomer(customer);
        entity.setBeneficiary(ben);
        entity.setPaymentType(paymentRequest.getPaymentType());
        entity.setAmount(paymentRequest.getAmount());

    }

    public  PaymentDetails toDto(PaymentEntity payment) {
        BeneficiaryDetails benDto = BeneficiaryMapper.toDto(payment.getBeneficiary());
        CustomerDetails customerDetails = CustomerMapper.toDto(payment.getCustomer());

        return PaymentDetails.builder().paymentId(payment.getPaymentId()).customerDetails(customerDetails)
                .beneficiaryDetails(benDto).paymentType(payment.getPaymentType()).amount(payment.getAmount()).build();
    }
}
