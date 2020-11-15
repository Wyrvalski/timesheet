package com.timesheet.projects.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "project_name")
@Table(name = "project_name")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectEntity {
    @Id
    @JsonIgnore
    private Long project_id;
    private String name;

    @JsonBackReference("projects")
    @ManyToMany
    @JoinTable(
            name = "projects_user_hours",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserInfoEntity> usersProject;
}
