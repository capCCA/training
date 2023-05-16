package training.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.training.controller.DeleteUserController;
import com.capgemini.training.service.DeleteUserService;

@ExtendWith(MockitoExtension.class)
class DeleteUserControllerTest {

    @Mock
    private DeleteUserService userDeleteService;

    @InjectMocks
    private DeleteUserController deleteUserController;

    @Test
    void testDeleteUser() {
        String customerId = "12345";

        ResponseEntity<Void> response = deleteUserController.delete(customerId);

        verify(userDeleteService).delete(customerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testDeleteUserNotFound() {
        String customerId = "12345";
        doThrow(EntityNotFoundException.class).when(userDeleteService).delete(customerId);

        ResponseEntity<Void> response = deleteUserController.delete(customerId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
