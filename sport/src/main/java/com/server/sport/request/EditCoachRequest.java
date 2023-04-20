package com.server.sport.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCoachRequest {
    private String newSurname;
    private String newName;
    private String newPosition;
  private String newDescription;
  private String newPhoto;
}
