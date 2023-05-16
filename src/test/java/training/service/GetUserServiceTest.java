package training.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;
import com.capgemini.training.service.GetUserService;

@ExtendWith(MockitoExtension.class)
public class GetUserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private GetUserService getUserService;

    @BeforeEach
    public void init() {
        getUserService = new GetUserService(userRepositoryMock);
    }

    @Test
    @DisplayName("When the userDto exists, it should return the same user")
    public void testGetExistingUser() {
        String customerId = "12345";

        UserDto userDto = UserDto.builder().customerId("custom1").documentType("DNI").documentNumber("3876543D")
                .name("Jaime").surName("Roldan").lastName("Aparicio").country("ENG").telephone(678342216).build();

        when(userRepositoryMock.findById(customerId)).thenReturn(Optional.of(MapperUser.converterToEntity(userDto)));

        UserDto result = getUserService.get(customerId);

        Assertions.assertEquals(userDto, result);
    }

    @Test
    @DisplayName("Cuando el usuario no existe deberia devolver null")
    public void testGetNonExistingUser() {
        String customerId = "54321";

        when(userRepositoryMock.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> getUserService.get(customerId));

    }
}
