package com.capgemini.training.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.training.dto.UserDto;
import com.capgemini.training.service.UserPutService;

@ExtendWith(MockitoExtension.class)
class UserPutControllerTest {

    @Mock
    private UserPutService userService;

    @InjectMocks
    private UserPutController userController;

    public UserDto createUserDto(String id) {
        return UserDto.builder().customerId(id).documentType("dni").documentNumber("123" + id).name("john" + id)
                .surname("green" + id).lastname("junior" + id).country("ESP").telephone(123).build();
    }

    @Test
    @DisplayName("Should update a UserDto with HTTP status OK")
    void testUpdateUser() {
        // given
        String id = "11";
        UserDto expectedDto = createUserDto(id);
//
//    Mockito.when(userService.save(ArgumentMatchers.any(UserDto.class))).thenReturn(expectedDto);
//
//    // when
//    ResponseEntity<UserDto> response = userController.save(expectedDto);
//
//    // then
//    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
//    Assertions.assertEquals(expectedDto, response.getBody());
        Assertions.assertEquals(expectedDto, "Not implemented yet");
    }

    @Test
    @DisplayName("Should update a UserDto with HTTP status NOT_FOUND")
    void testUpdateUserNotFound() {

    }

}
