package com.server.sport.request;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditEventRequest {
  private LocalDate newDate;
  private String newTitle;
  private String newCity;
  private String newDescription;
  private String newType;
  private String newDiscipline;
  private String newImage;
}
