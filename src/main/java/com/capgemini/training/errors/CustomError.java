package com.capgemini.training.errors;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomError {
    private HttpStatus status;
    private int error;
    private List<String> messages;
    
}
