package com.capgemini.training.controller.user;

import com.capgemini.training.dto.CustomerDto;
import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.services.user.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserSave {

    private final UserSaveService userSaveService;
    private final CustomerMapper customerMapper;

    @PostMapping("/save")
    public ResponseEntity<CustomerDto> saveUser(@RequestBody Customer customer) {

    if (userSaveService.saveUser(customer) != null) {

      return ResponseEntity.ok()
          .body(customerMapper.customerConverterDto(userSaveService.saveUser(customer)));

    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}
