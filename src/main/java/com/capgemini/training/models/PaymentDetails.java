package com.capgemini.training.models;

import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
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
