package com.timesheet.auth.v1.controller;

import com.timesheet.auth.v1.dto.response.UserResponse;
import com.timesheet.auth.v1.facade.CustomUserFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserControler {
  private final CustomUserFacade customUserFacade;

  @GetMapping(value = "/{email}")
  @ResponseBody
  public UserResponse findByEmail(@PathVariable String email) {
    return customUserFacade.findByEmail(email);
  }
}
