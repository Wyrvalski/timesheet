package com.timesheet.auth.v1.service;

import com.timesheet.auth.domain.model.UserEntity;
import com.timesheet.auth.domain.repository.CustomUserRepository;
import com.timesheet.commons.exception.ApiException;
import static com.timesheet.commons.exception.messages.AuthMessages.ERROR_USER_NOT_FOUND;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class UserService {
  private final CustomUserRepository customUserRepository;

  @Autowired
  public UserService(CustomUserRepository customUserRepository) {
    this.customUserRepository = customUserRepository;
  }

  public UserEntity findByEmail(String email) {
    if (Objects.isNull(email)) {
      throw new ApiException(HttpStatus.NOT_FOUND, ERROR_USER_NOT_FOUND);
    }
    return customUserRepository.findByEmailCustomUser(email);
  }
}
