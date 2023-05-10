package com.capgemini.training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.entity.CustomerEntity;
import com.capgemini.training.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerDetailsServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomerDetailsService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsers() {
        // Given
//        List<CustomerEntity> users = List.of(new CustomerEntity(1L, "user1", DeckType.FIBONACCI, "link"),
//                new CustomerEntity(2L, "user2", DeckType.TIME, "link2"));

        List<CustomerEntity> users = new ArrayList<CustomerEntity>();// List.of(new CustomerEntity(), new CustomerEntity());

        when(userRepository.findAll()).thenReturn(users);

        // When
        List<CustomerEntity> returnedUsers = userService.findAll();

        // Then
        assertNotNull(returnedUsers);
        assertEquals(users.size(), returnedUsers.size());
        assertTrue(returnedUsers.containsAll(users));
        verify(userRepository, times(1)).findAll();
    }
//
//    @Test
//    public void testGetUserById() {
//        // Given
//        long userId = 1L;
//        CustomerEntity user = new CustomerEntity(userId, "user1", DeckType.FIBONACCI, "link");
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//
//        // When
//        Optional<CustomerEntity> returnedUser = userService.getUserById(userId);
//
//        // Then
//        assertTrue(returnedUser.isPresent());
//        assertEquals(user, returnedUser.get());
//        verify(userRepository, times(1)).findById(userId);
//    }
//
//    @Test
//    public void testCreateUser() {
//        // Given
//        CustomerEntity user = new CustomerEntity(1L, "user1", DeckType.FIBONACCI, "link");
//        when(userRepository.save(user)).thenReturn(user);
//
//        // When
//        CustomerEntity createdUser = userService.save(user);
//
//        // Then
//        assertNotNull(createdUser);
//        assertEquals(user, createdUser);
//        verify(userRepository, times(1)).save(user);
//    }
//
//    @Test
//    public void testDeleteUser() {
//        // Given
//        long userId = 1L;
//        when(userRepository.findById(userId))
//                .thenReturn(Optional.of(new CustomerEntity(userId, "user1", DeckType.SIZES, "link")));
//
//        // When
//        ResponseEntity<?> response = userService.deleteUser(userId);
//
//        // Then
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void testDeleteUserNotFound() {
//        // Given
//        long userId = 1L;
//        when(userRepository.findById(userId)).thenReturn(Optional.empty());
//
//        // When
//        ResponseEntity<?> response = userService.deleteUser(userId);
//
//        // Then
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        verify(userRepository, never()).deleteById(userId);
//    }
//
//    @Test
//    public void testDeleteAll() {
//        // When
//        ResponseEntity<?> response = userService.deleteAll();
//
//        // Then
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        verify(userRepository, times(1)).deleteAll();
//    }
//
//    @Test
//    public void testDeleteAllNotFound() {
//        // Given
//        doThrow(new RuntimeException()).when(userRepository).deleteAll();
//
//        // When
//        ResponseEntity<?> response = userService.deleteAll();
//
//        // Then
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        verify(userRepository, times(1)).deleteAll();
//    }
}