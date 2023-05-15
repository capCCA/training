package com.capgemini.training.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
    DNI("dni"),
    PASSPORT("passport");

    private String value;
}
