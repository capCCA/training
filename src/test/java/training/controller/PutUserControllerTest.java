package training.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.training.controller.PutUserController;
import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.UpdateUserService;

//@WebMvcTest(PutUserController.class)
@ExtendWith(MockitoExtension.class)
public class PutUserControllerTest {

    @Mock
    private UpdateUserService updateUserService;

    @InjectMocks
    private PutUserController controller;

    @Test
    public void testUpdateUser() throws Exception {
        // Arrange
        String customerId = "123";
        UserDto userDto = UserDto.builder().customerId(customerId).build();

        when(updateUserService.update(eq(customerId), any(UserDto.class))).thenReturn(userDto);

        ResponseEntity<UserDto> response = controller.update(customerId, userDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testUpdateUserNotFound() throws Exception {
        // Arrange
        String customerId = "123";

        UserDto userDto = UserDto.builder().customerId("custom1").documentType("DNI").documentNumber("3876543D")
                .name("Jaime").surName("Roldan").lastName("Aparicio").country("ENG").telephone(678342216).build();

        when(updateUserService.update(eq(customerId), any(UserDto.class))).thenThrow(UserNotFoundException.class);

        assertThrows(UserNotFoundException.class, () -> controller.update(customerId, userDto));

    }
}
