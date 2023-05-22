package com.capgemini.training.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeneficiaryDetails {
    private static final String NOTEMPTY_MESSAGE = " cannot be empty";
    private static final String SIZE_MESSAGE = "The maximum length is ";

    @NotEmpty(message = NOTEMPTY_MESSAGE)
    @Size(max = 10, message = SIZE_MESSAGE + "10")
    private String beneficiaryId;
}
