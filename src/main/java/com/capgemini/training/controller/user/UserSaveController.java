package com.capgemini.training.controller.user;

import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.services.user.UserSaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserSaveController {

    private final UserSaveService userSaveService;
    @Operation(summary = "Save a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer was correctly saved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class)) }),
            @ApiResponse(responseCode = "400", description = "Customer object is not correct",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error while inserting Customer",
                    content = @Content), })
    @PostMapping("/")
    public ResponseEntity saveUser(@RequestBody Customer customer) {

        return userSaveService.saveUser(customer);

    }
}
