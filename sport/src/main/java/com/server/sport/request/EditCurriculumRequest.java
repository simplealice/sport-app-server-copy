package com.server.sport.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCurriculumRequest {
  private String newGroupNumber;
  private String newCoach;
  private String newDayOfWeek;
  private String newTimeFromTo;
}
