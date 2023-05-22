package com.capgemini.training.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Schema(description = "CustomerDetails")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetails {
    private static final String NOTEMPTY_MESSAGE = " cannot be empty";
    private static final String SIZE_MESSAGE = "The maximum length is ";

    @Schema(title = "customerId", example = "1234567891", description = "Customer identifier.")
    // @NotEmpty is both
    @NotEmpty(message = NOTEMPTY_MESSAGE)
    @Size(max = 10, message = SIZE_MESSAGE + "10")
    private String customerId;

    @Schema(
            title = "documentType",
            example = "DNI o Passport",
            description = "Customer document type identifier.")
    // private DocumentType documentType;
    private String documentType;

    @Schema(
            title = "documentNumber",
            example = "1234567891",
            description = "Customer document number.")
    @NotEmpty(message = NOTEMPTY_MESSAGE)
    @Size(max = 50, message = SIZE_MESSAGE + "50")
    private String documentNumber;

    @Schema(title = "name", example = "Jaimito", description = "Customer name.")
    @NotEmpty(message = NOTEMPTY_MESSAGE)
    @Size(max = 100, message = SIZE_MESSAGE + "100")
    private String name;

    @Schema(title = "surname", example = "Ronaldo", description = "Customer surname.")
    @NotEmpty(message = NOTEMPTY_MESSAGE)
    @Size(max = 100, message = SIZE_MESSAGE + "100")
    private String surname;

    @Schema(title = "lastName", example = "Eustaquio", description = "Customer lastname.")
    @Size(max = 100, message = SIZE_MESSAGE + "100")
    private String lastname;

    @Schema(title = "country", example = "ESP", description = "Customer country.")
    @NotEmpty(message = NOTEMPTY_MESSAGE)
    @Size(max = 3, message = SIZE_MESSAGE + "3")
    private String country;

    @Schema(title = "telephone", example = "678097823", description = "Customer telephone.")
    private Integer telephone;
}
