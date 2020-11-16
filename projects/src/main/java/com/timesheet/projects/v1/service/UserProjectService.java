package com.timesheet.projects.v1.service;

import com.timesheet.projects.domain.model.UserProjectEntity;
import com.timesheet.projects.domain.repository.UserProjectRepository;
import com.timesheet.projects.v1.service.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Date;
import java.sql.Time;
import java.util.List;

@Service
@Transactional
public class UserProjectService {
  private final UserProjectRepository userProjectRepository;

  public UserProjectService(UserProjectRepository userProjectRepository) {
    this.userProjectRepository = userProjectRepository;
  }

  public void updateHour(String hour, int id) {
    UserProjectEntity userProjectEntity = userProjectRepository.findByIdHour(id);
    String[] oldHourMinutesString = userProjectEntity.getHour().split(":");
    String completeHourString = CommonUtil.accumulateHours(oldHourMinutesString, hour);
    userProjectRepository.updateHour(completeHourString, id);
  }
}
