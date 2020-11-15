package com.timesheet.auth.v1.facade;

import com.timesheet.auth.domain.model.UserEntity;
import com.timesheet.auth.domain.repository.CustomUserRepository;
import com.timesheet.auth.v1.controller.UserControler;
import com.timesheet.auth.v1.dto.response.UserResponse;
import com.timesheet.auth.v1.mapper.UserMapper;
import com.timesheet.auth.v1.service.UserService;
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

@RunWith(MockitoJUnitRunner.class)
public class CustomUserFacedeTest {
    private UserService userService;
    private CustomUserFacade userFacade;
    private UserControler userControler;
    private CustomUserRepository userRepository;

    @Before
    public void init() {
        userRepository = mock(CustomUserRepository.class);
        userService = mock(UserService.class);
        userService = new UserService(userRepository);
        userFacade = new CustomUserFacade(userService);
        userControler = new UserControler(userFacade);
    }


    @Test
    public final void findByEmailTest() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setEmail("admin@admin.com");
        when(userService.findByEmail(anyString())).thenReturn(entity);
        UserResponse response1 = userFacade.findByEmail("admin@admin.com");
        Assert.assertEquals(entity.getEmail(), response1.getEmail());
    }
}
