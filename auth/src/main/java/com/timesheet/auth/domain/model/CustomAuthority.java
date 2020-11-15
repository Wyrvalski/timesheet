package com.timesheet.auth.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name = "authority")
@Table(name = "authority")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomAuthority implements GrantedAuthority, Serializable {

  private static final long serialVersionUID = 1271896544345896905L;

  @Id
  @NotNull
  @Size(max = 50)
  private String name;

  @Override
  public String getAuthority() {
    return name;
  }
}
