package com.timesheet.projects.v1.service.util;

import com.timesheet.projects.domain.model.UserProjectEntity;

public class CommonUtil {

  public static String accumulateHours(String[] oldHourMinutesString, String hour) {
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
      if (minutes < 10) {
        minutesString = minutes + "0";
      } else {
        minutesString = String.valueOf(minutes);
      }
      oldHourMinutesInt[0] = oldHourMinutesInt[0] + 1 + newHourMinutesInt[0];
      completeHourString = oldHourMinutesInt[0] + ":" + minutesString;
    } else {
      if (oldHourMinutesInt[1] + newHourMinutesInt[1] < 10) {
        minutesString = oldHourMinutesInt[1] + newHourMinutesInt[1] + "0";
      } else {
        minutesString = String.valueOf(oldHourMinutesInt[1] + newHourMinutesInt[1]);
      }
      oldHourMinutesInt[0] = oldHourMinutesInt[0] + newHourMinutesInt[0];
      completeHourString = oldHourMinutesInt[0] + ":" + minutesString;
    }
    return completeHourString;
  }
}
