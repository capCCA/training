package com.capgemini.training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.training.entity.User;
import com.capgemini.training.repository.UserRepository;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserGetService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsers() {
        // Given
//        List<User> users = List.of(new User(1L, "user1", DeckType.FIBONACCI, "link"),
//                new User(2L, "user2", DeckType.TIME, "link2"));

        List<User> users = new ArrayList<User>();// List.of(new User(), new User());

        when(userRepository.findAll()).thenReturn(users);

        // When
        List<User> returnedUsers = userService.findAll();

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
//        User user = new User(userId, "user1", DeckType.FIBONACCI, "link");
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//
//        // When
//        Optional<User> returnedUser = userService.getUserById(userId);
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
//        User user = new User(1L, "user1", DeckType.FIBONACCI, "link");
//        when(userRepository.save(user)).thenReturn(user);
//
//        // When
//        User createdUser = userService.save(user);
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
//                .thenReturn(Optional.of(new User(userId, "user1", DeckType.SIZES, "link")));
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