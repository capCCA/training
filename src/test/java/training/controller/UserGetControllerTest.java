package training.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.training.controller.GetUserController;
import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.GetUserService;

@ExtendWith(MockitoExtension.class)
public class UserGetControllerTest {

    @Mock
    private GetUserService getUserServiceMock;

    @InjectMocks
    private GetUserController userGetController;

    @Test
    @DisplayName("When the userDto exists, it should return the same user")
    public void testGetExistingUser() {
        String customerId = "12345";

        UserDto userDto = new UserDto();

        UserDto.builder().customerId("custom1").documentType("DNI").documentNumber("3876543D").name("Jaime")
                .surName("Roldan").lastName("Aparicio").country("ENG").telephone(678342216).build();

        when(getUserServiceMock.get(customerId)).thenReturn(userDto);

        ResponseEntity<UserDto> responseEntity = userGetController.get(customerId);

        // q el cuerpo y la respuesta sean correctas
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(userDto, responseEntity.getBody());

    }

    @Test
    public void testGetNonExistingUser() {
        String customerId = "54321";

        when(getUserServiceMock.get(anyString()))
                .thenThrow(new UserNotFoundException("customer does not exist in database"));

        ResponseEntity<UserDto> responseEntity = userGetController.get(customerId);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        Assertions.assertNull(responseEntity.getBody());

    }
}
