package com.timesheet.auth.v1.controller;

import com.timesheet.auth.domain.model.UserEntity;
import com.timesheet.auth.domain.repository.CustomUserRepository;
import com.timesheet.auth.v1.dto.response.UserResponse;
import com.timesheet.auth.v1.facade.CustomUserFacade;
import com.timesheet.auth.v1.mapper.UserMapper;
import static com.timesheet.auth.v1.mapper.UserMapper.mapToUserResponse;
import com.timesheet.auth.v1.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class userControllerTest {
    private UserService userService;
    private CustomUserFacade userFacade;
    private UserControler userControler;
    private CustomUserRepository userRepository;

    @Before
    public void init() {
        userRepository = mock(CustomUserRepository.class);
        userService = mock(UserService.class);
        userFacade = mock(CustomUserFacade.class);
        userService = new UserService(userRepository);
        userFacade = new CustomUserFacade(userService);
        userControler = new UserControler(userFacade);
    }

    @Test
    public void findByEmailTest() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setEmail("admin@admin.com");
        when(userRepository.findByEmailCustomUser("admin@admin.com")).thenReturn(entity);
        UserResponse response = userControler.findByEmail("admin@admin.com");
        Assert.assertNotNull(response);
        Assert.assertEquals(entity.getEmail(), response.getEmail());
    }


}
