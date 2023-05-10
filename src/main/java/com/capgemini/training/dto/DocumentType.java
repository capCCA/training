package com.capgemini.training.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
    DNI("dni"),
    PASSPORT("passport");

    private String value;
}
