package com.server.sport.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditAwardRequest {
  private String newName;
  private String newDescription;
  private String newImage;
}
