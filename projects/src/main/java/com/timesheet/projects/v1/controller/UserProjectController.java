package com.timesheet.projects.v1.controller;

import com.timesheet.projects.v1.service.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/userproject")
public class UserProjectController {

  private final UserProjectService userProjectService;

  @PutMapping(value = "/{id}")
  @ResponseBody
  public void updateHour(@PathVariable int id, @RequestParam("hour") String hour) {
    userProjectService.updateHour(hour, id);
  }

}
