package com.server.sport.request;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCompetitionRequest {
  private String newTitle;
  private LocalDate newDate;
  private String newDiscipline;
  private String newCity;
  private String newDescription;
  private String newImage;
}
