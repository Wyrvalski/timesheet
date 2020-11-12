package com.timesheet.auth.domain.model;

import static javax.persistence.GenerationType.IDENTITY;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "user")
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity implements Serializable, UserDetails {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(updatable = false, nullable = false)
  private Long id;

  private String password;
  private String email;
  private String name;

  @Column(name = "team")
  private String team;

  @ManyToMany
  @JoinTable(
      name = "user_authority",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "authority"))

  private Set<CustomAuthority> authorities;

  public UserEntity(UserEntity user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.authorities = user.getAuthorities();
    this.team = user.getTeam();
  }

  @Override
  public String getUsername() {
    return name;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
