package com.capgemini.training.models;

import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

        @NotNull
        private Long paymentId;
        @NotNull
        @Size( max = 10 )
        private CustomerEntity customer;
        @NotNull
        @Size( max = 10 )
        private BeneficiaryEntity beneficiaryEntity;
        @NotNull
        @Size( max = 10 )
        private String paymentType;
        @NotNull
        private BigDecimal amount;
        @NotNull
        private LocalDate creationDate;
        private LocalDate updateDate;
        
}
