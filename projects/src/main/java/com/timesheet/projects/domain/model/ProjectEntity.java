package com.timesheet.projects.domain.model;

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
    private Long project_id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "project" )
    private List<UserProjectEntity> projects;
}
