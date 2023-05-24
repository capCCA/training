package com.capgemini.training.api.controller;

import com.capgemini.training.api.model.CustomerDetails;
//import com.capgemini.training.api.model.UpdateCustomerRequest;
import com.capgemini.training.api.repository.model.CustomerEntity;
import java.util.UUID;

public class CustomerDetailsMother {

    private String customerId;
    private String documentType;
    private String documentNumber;
    private String name;
    private String surname;
    private String lastname;
    private String country;
    private Integer telephone;

    public CustomerDetailsMother() {
        this.customerId = UUID.randomUUID().toString();
        this.documentType = "DNI";
        this.documentNumber = "235234123M";
        this.name = "Mark";
        this.surname = "paquito";
        this.lastname = "fernandez";
        this.country = "ES";
        this.telephone = 688774455;
    }

    public static CustomerDetailsMother init() {
        return new CustomerDetailsMother();
    }


    public CustomerDetailsMother withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerDetailsMother withDocumentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public CustomerDetailsMother withDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public CustomerDetailsMother withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerDetailsMother withSurName(String surName) {
        this.surname = surname;
        return this;
    }

    public CustomerDetailsMother withLastName(String lastName) {
        this.lastname = lastname;
        return this;
    }

    public CustomerDetailsMother withCountry(String country) {
        this.country = country;
        return this;
    }

    public CustomerDetailsMother withTelephone(Integer telephone) {
        this.telephone = telephone;
        return this;
    }

    public CustomerDetails getCustomerDetails() {
        CustomerDetails customerDetails = CustomerDetails.builder().build();
        customerDetails.setCustomerId(this.customerId);
        customerDetails.setDocumentType(this.documentType);
        customerDetails.setDocumentNumber(this.documentNumber);
        customerDetails.setName(this.name);
        customerDetails.setSurname(this.surname);
        customerDetails.setLastname(this.lastname);
        customerDetails.setCountry(this.country);
        customerDetails.setTelephone(this.telephone);
        return customerDetails;
    }

    /*
    public UpdateCustomerRequest getUpdateCustomer() {
        UpdateCustomerRequest customerDetails = UpdateCustomerRequest.builder().build();
        customerDetails.setDocumentType(this.documentType);
        customerDetails.setDocumentNumber(this.documentNumber);
        customerDetails.setName(this.name);
        customerDetails.setSurname(this.surName);
        customerDetails.setLastname(this.lastName);
        customerDetails.setCountry(this.country);
        customerDetails.setTelephone(this.telephone);
        return customerDetails;
    }

     */

    public CustomerEntity getCustomerEntity() {
        CustomerEntity customerDetails = CustomerEntity.builder().build();
        customerDetails.setCustomerId(this.customerId);
        customerDetails.setDocumentType(this.documentType);
        customerDetails.setDocumentNumber(this.documentNumber);
        customerDetails.setSurname(this.surname);
        customerDetails.setLastname(this.lastname);
        customerDetails.setName(this.name);
        customerDetails.setCountry(this.country);
        customerDetails.setTelephone(this.telephone);
        return customerDetails;
    }
}
