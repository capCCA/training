package com.capgemini.training.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class BeneficiaryDto {
    private static final String NOTBLANK_MESSAGE = " Cannot be blank";
    private static final String NOTNULL_MESSAGE = " It is mandatory, cannot be null";
    private static final String SIZE_MESSAGE = "The maximum length is ";

    @NotBlank(message = "beneficiaryId" + NOTBLANK_MESSAGE)
    @NotNull(message = "beneficiaryId" + NOTNULL_MESSAGE)
    @Size(max = 10, message = SIZE_MESSAGE + "10")
    private String beneficiaryId;
}