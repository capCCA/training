package com.capgemini.training.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@Schema(description = "CustomerDetails")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
  private static final String NOTNULL_MESSAGE = "is mandatory, cannot be null";
  private static final String SIZE_MESSAGE = "the length must be less than ";

  @NotNull(message = "customerId " + NOTNULL_MESSAGE)
  @Size(max = 10, message = SIZE_MESSAGE + "10")
  @Schema(title = "customer_id", example = "123456789", description = "Customer identifier")
  private String customerId;

  @NotNull(message = "documentType " + NOTNULL_MESSAGE)
  @Schema(
      title = "documentType",
      example = "DNI",
      description = "Customer document type identifier.")
  private DocumentType documentType;

  @NotNull(message = "documentNumber " + NOTNULL_MESSAGE)
  @Size(max = 50, message = SIZE_MESSAGE + "50")
  @Schema(
      title = "documentNumber",
      example = "1234567891",
      description = "Customer document number.")
  private String documentNumber;

  @NotNull(message = "name " + NOTNULL_MESSAGE)
  @Size(max = 100, message = SIZE_MESSAGE + "100")
  @Schema(title = "name", example = "Manuel", description = "Customer name.")
  private String name;

  @NotNull(message = "surname " + NOTNULL_MESSAGE)
  @Size(max = 100, message = SIZE_MESSAGE + "100")
  @Schema(title = "surName", example = "Garcia", description = "Customer surName.")
  private String surname;

  @Size(max = 100, message = SIZE_MESSAGE + "100")
  @Schema(title = "lastName", example = "Herrera", description = "Customer lastName.")
  private String lastname;

  @NotNull(message = "country " + NOTNULL_MESSAGE)
  @Size(max = 3, message = SIZE_MESSAGE + "3")
  @Schema(title = "country", example = "ESP", description = "Customer country.")
  private String country;

  @Schema(title = "telephone", example = "123456789", description = "Customer telephone.")
  private Integer telephone;
}
