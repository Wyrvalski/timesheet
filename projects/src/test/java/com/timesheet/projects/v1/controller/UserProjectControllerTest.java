package com.timesheet.projects.v1.controller;

import com.timesheet.projects.domain.model.UserInfoEntity;
import com.timesheet.projects.domain.model.UserProjectEntity;
import com.timesheet.projects.domain.repository.UserProjectRepository;
import com.timesheet.projects.v1.service.UserProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserProjectControllerTest {
    private UserProjectService userProjectService;
    private UserProjectRepository userProjectRepository;
    private UserProjectController userProjectController;

    @Before
    public void init() {
        userProjectRepository = mock(UserProjectRepository.class);
        userProjectService = mock(UserProjectService.class);
        userProjectService = new UserProjectService(userProjectRepository);
        userProjectController = new UserProjectController(userProjectService);
    }

    @Test
    public void updateHour() {
        UserProjectEntity entity = new UserProjectEntity();
        entity.setHour("03:00");
        entity.setId(1L);
        when(userProjectRepository.findByIdHour(anyInt())).thenReturn(entity);
        userProjectController.updateHour(1, entity.getHour());
        verify(userProjectRepository).updateHour("6:00",1);
    }
}
