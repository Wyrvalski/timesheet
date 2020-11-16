package com.timesheet.projects.v1.service;

import com.timesheet.projects.domain.model.UserProjectEntity;
import com.timesheet.projects.domain.repository.UserProjectRepository;
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
        Integer[] oldHourMinutesInt = new Integer[2];
        oldHourMinutesInt[0] = Integer.parseInt(oldHourMinutesString[0]);
        oldHourMinutesInt[1] = Integer.parseInt(oldHourMinutesString[1]);
        String[] newHourMinutesString = hour.split(":");
        Integer[] newHourMinutesInt = new Integer[2];
        newHourMinutesInt[0] = Integer.parseInt(newHourMinutesString[0]);
        newHourMinutesInt[1] = Integer.parseInt(newHourMinutesString[1]);
        int minutes;
        String minutesString;
        String completeHourString;
        if (oldHourMinutesInt[1] + newHourMinutesInt[1] >= 60) {
            minutes = (oldHourMinutesInt[1] + newHourMinutesInt[1]) - 60;
            if(minutes < 10) {
                minutesString = minutes + "0";
            } else {
                minutesString = String.valueOf(minutes);
            }
            oldHourMinutesInt[0] = oldHourMinutesInt[0] + 1 + newHourMinutesInt[0];
            completeHourString = oldHourMinutesInt[0] + ":" + minutesString;
        } else{
            if(oldHourMinutesInt[1] + newHourMinutesInt[1] < 10) {
                minutesString = oldHourMinutesInt[1] + newHourMinutesInt[1] + "0";
            } else {
                minutesString = String.valueOf(oldHourMinutesInt[1] + newHourMinutesInt[1]);
            }
            oldHourMinutesInt[0] = oldHourMinutesInt[0] + newHourMinutesInt[0];
            completeHourString = oldHourMinutesInt[0] + ":" + minutesString;

        }
        userProjectRepository.updateHour(completeHourString, id);
    }
}
