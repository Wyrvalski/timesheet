package com.timesheet.auth.v1.facade;

import com.timesheet.auth.v1.dto.response.UserResponse;
import static com.timesheet.auth.v1.mapper.UserMapper.mapToUserResponse;
import com.timesheet.auth.v1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CustomUserFacade {

    private final UserService userService;

    public UserResponse findByEmail(String email) {
        return mapToUserResponse(userService.findByEmail(email));
    }
}
