package com.server.sport.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditInfoClubRequest {
  private String newTitle;
  private String newDescription;
  private String newPhone;
  private String newAddress;
}
