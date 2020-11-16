package com.timesheet.projects.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "projects_user_hours")
@Table(name = "projects_user_hours")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserProjectEntity {
    @Id
    private Long id;
    private String hour;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserInfoEntity user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    ProjectEntity project;
}
