package com.timesheet.auth.v1.service;

import com.timesheet.auth.domain.model.CustomAuthority;
import com.timesheet.auth.domain.model.UserEntity;
import com.timesheet.auth.domain.repository.CustomUserRepository;
import com.timesheet.commons.exception.ApiException;
import static com.timesheet.commons.exception.messages.AuthMessages.ERROR_USER_NOT_FOUND;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

  private final CustomUserRepository customUserRepository;

  @Override
  public UserDetails loadUserByUsername(String email) {
    return customUserRepository.findByEmail(email)
        .map(user -> new User(user.getEmail(), user.getPassword(), getGrantedAuthorities(user)))
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ERROR_USER_NOT_FOUND));
  }

  private Collection<GrantedAuthority> getGrantedAuthorities(UserEntity user) {
    final Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    for (CustomAuthority authority : user.getAuthorities()) {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
      grantedAuthorities.add(grantedAuthority);
    }
    return grantedAuthorities;
  }
}