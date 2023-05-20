package com.server.sport.user;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditUserRequest {
  private String newSurname;
  private String newName;
  private LocalDate newBirthDate;
  private String newCategory;
  private String newKuDan;
  private String newMajor;
  private String newTeam;
  private String newMedals;
  private String newGroupSc;
  private Integer newScores;
}
