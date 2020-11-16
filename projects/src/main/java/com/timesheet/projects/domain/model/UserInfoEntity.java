package com.timesheet.projects.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoEntity {
    @Id
    private Long user_id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user" )
    private List<UserProjectEntity> projects;

}
