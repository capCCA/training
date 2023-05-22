package com.capgemini.training.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "UpdateCustomerRequest")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerRequest {
    // no customerId and no validation for the fields.
    //private String customerId;
    @Schema(
            title = "documentType",
            example = "DNI",
            description = "Customer document type identifier.")
    private String documentType;
    @Schema(
            title = "documentNumber",
            example = "1234567891",
            description = "Customer document number.")
    private String documentNumber;
    @Schema(title = "name", example = "Jaimito", description = "Customer name.")
    private String name;

    @Schema(title = "surname", example = "Ronaldo", description = "Customer surName.")
    private String surname;

    @Schema(title = "lastName", example = "Eustaquio", description = "Customer lastName.")
    private String lastname;

    @Schema(title = "country", example = "Spain", description = "Customer country.")
    private String country;

    @Schema(title = "telephone", example = "678097823", description = "Customer telephone.")
    private Integer telephone;
}
