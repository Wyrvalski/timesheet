package com.timesheet.auth.v1.mapper;

import com.timesheet.auth.domain.model.UserEntity;
import com.timesheet.auth.v1.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserResponse mapToUserResponse(UserEntity customUserEntity) {
        return UserResponse.builder()
                .id(customUserEntity.getId())
                .email(customUserEntity.getEmail())
                .name(customUserEntity.getName())
                .team(customUserEntity.getTeam())
                .authorities(customUserEntity.getAuthorities())
                .build();
    }
}
