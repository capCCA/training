package com.capgemini.training.service;

import com.capgemini.training.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log
public class UserDeleteService {
  private final UserRepository userRepository;

  /**
   * Deletes a User with given id
   *
   * @param id
   * @return ResponseEntity with 200 OK or 404 Not FOUND
   */
  public ResponseEntity<Void> delete(String id) {
    try {
      if (userRepository.findById(id).orElse(null) == null) {
        return ResponseEntity.notFound().build();
      }
      userRepository.deleteById(id);
      return ResponseEntity.ok().build();

    } catch (Exception e) {
      log.info("delete " + id + ": Problem found " + e.getMessage());
      return ResponseEntity.notFound().build();
    }
  }
}
