package com.capgemini.training.mappers;

import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.PaymentEntity;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentDetailsResponse toPaymentDetails(PaymentEntity paymentEntity){

        return PaymentDetailsResponse.builder()
                .paymentId( paymentEntity.getPaymentId() )
                .customer( paymentEntity.getCustomer() )
                .beneficiary( paymentEntity.getBeneficiary() )
                .paymentType( paymentEntity.getPaymentType() )
                .amount( paymentEntity.getAmount() )
                .creationDate( LocalDate.now() )
                .updateDate( paymentEntity.getUpdateDate() )
                .build();

    }

    public PaymentEntity toEntityFromRequest ( PaymentDetailsRequest paymentDetailsRequest){

        return PaymentEntity.builder()
                .paymentId( paymentDetailsRequest.getPaymentId() )
                .customer( paymentDetailsRequest.getCustomer() )
                .beneficiary( paymentDetailsRequest.getBeneficiary() )
                .paymentType( paymentDetailsRequest.getPaymentType() )
                .amount( paymentDetailsRequest.getAmount() )
                .creationDate( LocalDate.now() )
                .updateDate( paymentDetailsRequest.getUpdateDate() )
                .build();
    }
}
