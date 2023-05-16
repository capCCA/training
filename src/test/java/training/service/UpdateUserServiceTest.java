package training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;
import com.capgemini.training.service.UpdateUserService;

@ExtendWith(MockitoExtension.class)
class UpdateUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UpdateUserService updateUserService;

    @Test
    @DisplayName("This test update an existing idCustomer")
    void testUpdateUser() {
        // Mock data

        UserDto userDto = UserDto.builder().customerId(null).build();

        UserEntity userEntity = UserEntity.builder().customerId("3333").documentType("DNI").documentNumber("3876543D")
                .name("Jaime").surName("Roldan").lastName("Aparicio").country("ENG").telephone(678342216).build();

        String idCustomer = "33333";

        // Mock repository behavior
        when(userRepository.findById(idCustomer)).thenReturn(Optional.of(userEntity));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        // Call the update service method
        UserDto result = updateUserService.update(idCustomer, userDto);

        // Verify repository method calls
        verify(userRepository, times(1)).findById(idCustomer);
        verify(userRepository, times(1)).save(userEntity);

        // Verify the result
        assertNotNull(result);
        assertEquals(userDto, result);
    }

    @Test
    @DisplayName("This test throws an UserNotFoundException, idCustomer not found")
    void testUpdateUserNotFound() {
        // Mock data
        String idCustomer = "12345";

        UserDto userDto = UserDto.builder().customerId(null).build();

        // Mock repository behavior
        when(userRepository.findById(idCustomer)).thenReturn(Optional.empty());

        // Call the update service method and verify that it throws an exception
        assertThrows(UserNotFoundException.class, () -> updateUserService.update(idCustomer, userDto));

        // Verify repository method calls
        verify(userRepository, times(1)).findById(idCustomer);
        verify(userRepository, never()).save(any(UserEntity.class));
    }
}
