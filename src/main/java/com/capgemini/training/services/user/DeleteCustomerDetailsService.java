package com.capgemini.training.services.user;

import com.capgemini.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerService {

  // Repository injection
  private final CustomerRepository customerRepository;

  public ResponseEntity delete(String id ) {


    if( customerRepository.findById(id).isPresent() ){

      customerRepository.deleteById(id);
      return ResponseEntity
              .ok("El usuario con id " + id + " Ha sido eliminado correctamente");

    }
    return ResponseEntity.status(404)
            .body("El usuario con id " + id +  " no se encuentra registrado");
  }
}
