package com.capgemini.training.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Component
public class CustomerDto implements Serializable {
    private String customerId;
    private String DocumentType;
    private String DocumentNumber;
    private String name;
    private String surName;
    private String lastName;
    private String country;
    private int telephone;
    private Date creationDate;
    private Date UpdateDate;
    private String customMessage;
}
