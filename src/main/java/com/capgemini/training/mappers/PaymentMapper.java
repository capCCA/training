package com.capgemini.training.mappers;

import com.capgemini.training.models.PaymentDetails;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.models.PaymentEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PaymentMapper {

    public PaymentDetails toPaymentDetails(PaymentEntity paymentEntity){

        return PaymentDetails.builder()
                .paymentId( paymentEntity.getPaymentId() )
                .customer( paymentEntity.getCustomer() )
                .beneficiaryEntity( paymentEntity.getBeneficiaryEntity() )
                .paymentType( paymentEntity.getPaymentType() )
                .amount( paymentEntity.getAmount() )
                .creationDate( LocalDate.now() )
                .updateDate( paymentEntity.getUpdateDate() )
                .build();

    }

    public PaymentEntity toEntityFromRequest ( PaymentDetails paymentDetails ){

        return PaymentEntity.builder()
                .paymentId( paymentDetails.getPaymentId() )
                .customer( paymentDetails.getCustomer() )
                .beneficiaryEntity( paymentDetails.getBeneficiaryEntity() )
                .paymentType( paymentDetails.getPaymentType() )
                .amount( paymentDetails.getAmount() )
                .creationDate( LocalDate.now() )
                .updateDate( paymentDetails.getUpdateDate() )
                .build();
    }
}
