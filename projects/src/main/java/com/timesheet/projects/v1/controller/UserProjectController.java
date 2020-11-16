package com.timesheet.projects.v1.controller;

import com.timesheet.projects.domain.model.UserInfoEntity;
import com.timesheet.projects.domain.model.UserProjectEntity;
import com.timesheet.projects.v1.service.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/userproject")
public class UserProjectController {

    private final UserProjectService userProjectService;

    @PutMapping(value = "/{id}")
    @ResponseBody
    public void findByEmail(@PathVariable int id, @RequestParam("hour") String hour) {
        userProjectService.updateHour(hour, id);
    }

}
