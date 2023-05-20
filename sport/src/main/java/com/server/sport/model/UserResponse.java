package com.server.sport.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserResponse {

  private Integer id;
  private String role;
  private String email;
  private String surname;
  private String name;
  private LocalDate birthDate;
  private String category;
  private String kuDan;
  private String major;
  private String team;
  private String medals;
  private String groupSc;
  private Integer scores;
}
