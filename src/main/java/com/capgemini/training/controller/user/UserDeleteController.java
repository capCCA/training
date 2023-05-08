package com.capgemini.training.controller.user;

import com.capgemini.training.services.user.UserDeleteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserDeleteController {

    private final UserDeleteService userDeleteService;
    @Operation(summary = "Remove a customer by its ID")
    //Documentating Status codes
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer was correctly removed",
                    content = { @Content(mediaType = "application/json")
                             }),
            @ApiResponse(responseCode = "404", description = "'ID' does not match with an existing customer",
                    content = @Content)
    })
    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteUser(@PathVariable @NotNull(message="Inserte el ID del usuario que desea eliminar") String customerId) {


        if ( userDeleteService.delete(customerId) ) {
            return ResponseEntity
                    .ok("El usuario con id " + customerId + " Ha sido eliminado correctamente");
        }
        return ResponseEntity.status(404)
                .body("El usuario con id " + customerId +  " no se encuentra registrado");

    }
}
