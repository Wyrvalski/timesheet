package com.timesheet.projects.v1.controller;

import com.timesheet.projects.domain.model.UserInfoEntity;
import com.timesheet.projects.v1.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping(value = "/{email}")
    @ResponseBody
    public UserInfoEntity findByEmail(@PathVariable String email) {
        return userInfoService.findByEmail(email);
    }
    @GetMapping(value = "/all")
    @ResponseBody
    public List<UserInfoEntity> findAll() {
        return userInfoService.findAll();
    }
}
