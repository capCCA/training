package com.capgemini.training.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Component
public class CustomerDto implements Serializable {
    @NotNull(message = "El ID de cliente no puede estar vacío")
    @Size(max = 10)
    private String customerId;
    @NotNull(message = "El tipo de documento del cliente no puede estar vacío")
    @Size(max = 8)
    private DocumentTypeEnum documentType;
    @NotNull(message = "El número de documento no puede estar vacío")
    @Size(max = 50)
    private String documentNumber;
    @NotNull(message = "El nombre del cliente no puede estar vacío")
    @Size(max = 100)
    private String name;
    @NotNull(message = "El apodo del cliente no puede estar vacío")
    @Size(max = 100)
    private String surname;
    @Size(max = 100)
    private String lastname;
    @NotNull(message = "El país del cliente no puede estar vacío")
    @Size(max = 3)
    private String country;
    private int telephone;
    @NotNull(message = "La fecha de creación no puede estar vacío")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate creationDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate updateDate;
    private String customMessage;


}
