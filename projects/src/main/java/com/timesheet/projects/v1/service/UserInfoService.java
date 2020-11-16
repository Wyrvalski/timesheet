package com.timesheet.projects.v1.service;

import com.timesheet.commons.exception.ApiException;
import static com.timesheet.commons.exception.messages.AuthMessages.ERROR_USER_NOT_FOUND;
import com.timesheet.projects.domain.model.UserInfoEntity;
import com.timesheet.projects.domain.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserInfoService {

  private final UserInfoRepository userInfoRepository;

  @Autowired
  public UserInfoService(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  public UserInfoEntity findByEmail(String email) {
    if (Objects.isNull(email)) {
      throw new ApiException(HttpStatus.NOT_FOUND, ERROR_USER_NOT_FOUND);
    }
    return userInfoRepository.findByEmailUser(email);
  }

  public List<UserInfoEntity> findAll() {
    return userInfoRepository.findAll();
  }
}
