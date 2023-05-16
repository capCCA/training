package training.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.training.controller.PostUserController;
import com.capgemini.training.exceptions.UserBadRequestException;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.SaveUserService;

@ExtendWith(MockitoExtension.class)
class PostUserControllerTest {

    @Mock
    private SaveUserService userSaveService;

    @InjectMocks
    private PostUserController postUserController;

    @BeforeEach
    void setUp() {
        postUserController = new PostUserController(userSaveService);
    }

    @Test
    void testSaveUser() {

        UserDto userDto = UserDto.builder().customerId("444").documentType("DNI").documentNumber("434324414")
                .name("Maria").surName("Setien").lastName("Manso").country("ESP").telephone(12344467).build();

        when(userSaveService.saveUser(userDto)).thenReturn(userDto);

        ResponseEntity<UserDto> response = postUserController.saveUser(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userDto, response.getBody());
    }

    @Test
    @DisplayName("Throws UserBadRequestException if Id already exists")
    void shouldThrowBadRequestWhenIdAlreadyExists() {

      when(userSaveService.saveUser(any(UserDto.class)))
          .thenThrow(UserBadRequestException.class);

      assertThrows(
              UserBadRequestException.class,
          () ->
              postUserController.saveUser(
                  UserDto.builder()
                      .customerId("0999")
                      .documentType("DNI")
                      .documentNumber("123456789")
                      .name("null")
                      .surName("GARCIA")
                      .lastName("LOPEZ")
                      .country("ESP")
                      .telephone(1234567)
                      .build()));
    }

}
