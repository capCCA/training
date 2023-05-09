package com.capgemini.training.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String customerId;

    @NotNull
    private String documentType;

    @NotNull
    private String documentNumber;

    @NotNull
    private String name;

    @NotNull
    private String surName;

    private String lastName;

    @NotNull
    private String country;

    private Integer telephone;

}
