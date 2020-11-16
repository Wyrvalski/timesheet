package com.timesheet.projects.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "project_name")
@Table(name = "project_name")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectEntity {
  @Id
  @Column(name = "project_id")
  private Long projectId;
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "project")
  private List<UserProjectEntity> projects;
}
