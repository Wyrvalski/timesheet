package com.timesheet.auth.v1.service;

import com.timesheet.auth.domain.model.UserEntity;
import com.timesheet.auth.domain.repository.CustomUserRepository;
import com.timesheet.auth.v1.controller.UserControler;
import com.timesheet.auth.v1.dto.response.UserResponse;
import com.timesheet.auth.v1.facade.CustomUserFacade;
import com.timesheet.auth.v1.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import javax.inject.Inject;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserService userService;
    private CustomUserFacade userFacade;
    private UserControler userControler;
    private CustomUserRepository userRepository;

    @Before
    public void init() {
        userRepository = mock(CustomUserRepository.class);
        userFacade = mock(CustomUserFacade.class);
        userService = new UserService(userRepository);
        userFacade = new CustomUserFacade(userService);
        userControler = new UserControler(userFacade);
    }


    @Test
    public final void findByEmailTest() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setEmail("admin@admin.com");
        when(userRepository.findByEmailCustomUser(anyString())).thenReturn(entity);
        UserEntity entity1 = userService.findByEmail("admin@admin.com");
        Assert.assertEquals(entity, entity1);
    }
}
