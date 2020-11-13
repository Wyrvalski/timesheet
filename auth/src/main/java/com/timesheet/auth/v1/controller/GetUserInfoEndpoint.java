package com.timesheet.auth.v1.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@FrameworkEndpoint
@Api(value = "User Info", tags = "User Info Controller")
public class GetUserInfoEndpoint {

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/oauth/check_user")
  public ResponseEntity<Principal> get(Principal user) {
    return ResponseEntity.ok(user);
  }
}
