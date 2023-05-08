package com.capgemini.training.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Component
public class CustomerDto implements Serializable {
    @NotNull
    @Size(max = 10)
    private String customerId;
    @NotNull
    @Size(max = 8)
    private String DocumentType;
    @NotNull
    @Size(max = 50)
    private String DocumentNumber;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 100)
    private String surname;
    @Size(max = 100)
    private String lastname;
    @NotNull
    @Size(max = 3)
    private String country;
    private int telephone;
    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date creationDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date updateDate;
    private String customMessage;
}
