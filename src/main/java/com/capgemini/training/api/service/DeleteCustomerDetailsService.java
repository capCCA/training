package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log
public class DeleteCustomerDetailsService {
  private final UserRepository userRepository;

  /**
   * Deletes a CustomerEntity with given id
   *
   * @param id
   * @return ResponseEntity with 200 OK or 404 Not FOUND
   */
  public void delete(String id) {

    if (userRepository.existsById(id)) {
      userRepository.deleteById(id);
    } else {
      throw new CustomerNotFoundException();
    }
  }

  //  public ResponseEntity<Void> delete(String id) {
  //    try {
  //      if (userRepository.findById(id).orElse(null) == null) {
  //        return ResponseEntity.notFound().build();
  //      }
  //      userRepository.deleteById(id);
  //      return ResponseEntity.ok().build();
  //
  //    } catch (Exception e) {
  //      log.info("delete " + id + ": Problem found " + e.getMessage());
  //      return ResponseEntity.notFound().build();
  //    }
  //  }
}
