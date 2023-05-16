package training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.exceptions.UserBadRequestException;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;
import com.capgemini.training.service.SaveUserService;

public class SaveUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private SaveUserService saveUserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {

        UserDto userDto = UserDto.builder().customerId("custom1").documentType("DNI").documentNumber("3876543D")
                .name("Jaime").surName("Roldan").lastName("Aparicio").country("ENG").telephone(678342216).build();

        UserEntity userEntity = MapperUser.converterToEntity(userDto);

        // when(userRepository.existsById("2222").thenReturn(false));
        when(userRepository.existsById(anyString())).thenReturn(false);
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        // when
        UserDto savedUser = saveUserService.saveUser(userDto);

        assertNotNull(savedUser);
        assertEquals(userDto, savedUser);

    }

    @Test
    public void testSaveUserThrowsBadRequestException() {
        // given

        UserDto userDto = UserDto.builder().customerId("3333").documentType("DNI").documentNumber("3876543D")
                .name("Jaime").surName("Roldan").lastName("Aparicio").country("ENG").telephone(678342216).build();

        when(userRepository.existsById(anyString())).thenReturn(true);

        // then
        Assertions.assertThrows(UserBadRequestException.class, () -> {
            saveUserService.saveUser(userDto);
        });

    }
}
