package com.timesheet.projects.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoEntity {
  @Id
  @Column(name = "user_id")
  private Long userId;
  private String name;
  private String email;

  @OneToMany(mappedBy = "user")
  private List<UserProjectEntity> projects;

}
