package com.server.sport.request;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditNewsRequest {
  private String newTitle;
  private LocalDate newDate;
  private String newDescription;
  private String newImage;
}
