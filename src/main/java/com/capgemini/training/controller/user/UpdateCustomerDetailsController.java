package com.capgemini.training.controller.user;

import com.capgemini.training.models.CustomerDto;
import com.capgemini.training.repository.models.Customer;
import com.capgemini.training.services.user.EditCustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserPutController {

    private final EditCustomerService editCustomerService;

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
    public ResponseEntity<CustomerDto> updateUser( @Valid @RequestBody Customer customer) {

        return editCustomerService.editUser(customer);

    }
}
