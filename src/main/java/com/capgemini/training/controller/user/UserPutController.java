package com.capgemini.training.controller.user;

import com.capgemini.training.dto.CustomerDto;
import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.services.user.UserEditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserPutController {

    private final UserEditService userEditService;

    @Operation(summary = "Update a customer")
    //Documentating Status codes
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer was correctly updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class)) }),
            @ApiResponse(responseCode = "400", description = "Customer was not updated as 'ID' provided does not match with an existing customer",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error while saving user on system. Contact your administrator ",
            content = @Content) })

    @PutMapping("/")
    public ResponseEntity<CustomerDto> updateUser(@RequestBody Customer customer) {

        return userEditService.editUser(customer);

    }
}
