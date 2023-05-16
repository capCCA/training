package training.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.repository.UserRepository;
import com.capgemini.training.service.DeleteUserService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DeleteUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DeleteUserService deleteUserService;

    @Test
    void testDeleteUser() {
        // Mock data
        String customerId = "12345";
        UserEntity userEntity = new UserEntity();

        // Mock repository behavior
        when(userRepository.findById(customerId)).thenReturn(Optional.of(userEntity));

        // Call the delete service method
        deleteUserService.delete(customerId);

        // Verify repository method calls
        verify(userRepository, times(1)).findById(customerId);
        verify(userRepository, times(1)).deleteById(customerId);
    }

    @Test
    void testDeleteUserNotFound() {
        // Mock data
        String customerId = "12345";

        // Mock repository behavior
        when(userRepository.findById(customerId)).thenReturn(Optional.empty());

        // Call the delete service method and verify that it throws an exception
        assertThrows(EntityNotFoundException.class, () -> deleteUserService.delete(customerId));

        // Verify repository method calls
        verify(userRepository, times(1)).findById(customerId);
        verify(userRepository, never()).deleteById(anyString());
    }
}
