package com.timesheet.auth.v1.dto.response;

import com.timesheet.auth.domain.model.CustomAuthority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String email;
    private String name;
    private String team;
    private Set<CustomAuthority> authorities;
}
