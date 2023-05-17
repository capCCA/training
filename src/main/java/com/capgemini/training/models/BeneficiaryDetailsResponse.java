package com.capgemini.training.models;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDetailsResponse {

    @NotNull
    @Size( max = 10 )
    private String beneficiaryId;

    @NotNull
    private LocalDate creationDate;

    private LocalDate updateDate;

}
