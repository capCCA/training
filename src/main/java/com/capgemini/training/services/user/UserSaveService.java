package com.capgemini.training.services.user;

import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSaveService {

    //Repository injection
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public ResponseEntity saveUser( Customer customer ){

        //Removing spaces from customerId to save it clean in database
        customer.setCustomerId(customer.getCustomerId().trim());

        //Checking that ID does not exist on database
        if( !customerRepository.findById( customer.getCustomerId() ).isPresent() ){
          // Avoiding null entitities
          if (customer != null) {

            if (customerRepository.save(customer) != null) {

              return ResponseEntity.ok()
                  .body(
                      customerMapper.customerConverterDto(
                          customer, "El usuario " + customer + " ha sido insertado correctamente"));
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Fallo al intentar insertar el usuario " + customer);
          }
          return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body("El objecto customer enviado es incorrecto.");

        }return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El ID insertado ya se encuentra registrado en la base de datos");

    }
}
