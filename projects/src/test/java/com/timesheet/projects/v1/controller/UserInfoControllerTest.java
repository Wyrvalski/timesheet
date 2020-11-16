package com.timesheet.projects.v1.controller;

import com.timesheet.projects.domain.model.UserInfoEntity;
import com.timesheet.projects.domain.repository.UserInfoRepository;
import com.timesheet.projects.v1.controller.UserInfoController;
import com.timesheet.projects.v1.service.UserInfoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserInfoControllerTest {
    private UserInfoService userInfoService;
    private UserInfoRepository userInfoRepository;
    private UserInfoController userInfoController;

    @Before
    public void init() {
        userInfoService = mock(UserInfoService.class);
        userInfoRepository = mock(UserInfoRepository.class);
        userInfoService = new UserInfoService(userInfoRepository);
        userInfoController = new UserInfoController(userInfoService);
    }

    @Test
    public void findByEmailTest() {
        UserInfoEntity entity = new UserInfoEntity();
        entity.setUserId(1L);
        entity.setEmail("admin@admin.com");
        when(userInfoRepository.findByEmailUser("admin@admin.com")).thenReturn(entity);
        UserInfoEntity response = userInfoController.findByEmail("admin@admin.com");
        Assert.assertNotNull(response);
        Assert.assertEquals(entity.getEmail(), response.getEmail());
    }

    @Test
    public void findByAllTest() {
        UserInfoEntity entity = new UserInfoEntity();
        UserInfoEntity entity2 = new UserInfoEntity();
        entity.setUserId(1L);
        entity.setEmail("admin@admin.com");
        entity2.setUserId(2L);
        entity2.setEmail("teste@teste.com");
        List<UserInfoEntity> users = new ArrayList<>();
        users.add(entity);
        users.add(entity2);
        when(userInfoRepository.findAll()).thenReturn(users);
        List<UserInfoEntity> response = userInfoController.findAll();
        Assert.assertNotNull(response);
        Assert.assertEquals(users, response);
    }
}
