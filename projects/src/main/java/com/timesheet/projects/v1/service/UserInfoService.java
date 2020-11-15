package com.timesheet.projects.v1.service;

import com.timesheet.projects.domain.UserInfoEntity;
import com.timesheet.projects.domain.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoService (UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }
    public UserInfoEntity findByEmail(String email) {
        System.out.println(email);
        return userInfoRepository.findByEmailUser(email);
    }
}
