package com.server.sport.controller;

import com.server.sport.model.InfoClub;
import com.server.sport.request.EditInfoClubRequest;
import com.server.sport.service.InfoClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/club")
public class InfoClubController {
  @Autowired
  private InfoClubService infoClubService;

  @GetMapping(value = "/get")
  public InfoClub getInfoClub() {
    return infoClubService.getInfoClub();
  }

  @PutMapping("/edit")
  public ResponseEntity<InfoClub> editInfoClub(@RequestBody EditInfoClubRequest editInfoClubRequest) {
    InfoClub editInfoClub = infoClubService.editInfoClub(
        editInfoClubRequest.getNewTitle(),
        editInfoClubRequest.getNewDescription(),
        editInfoClubRequest.getNewPhone(),
        editInfoClubRequest.getNewAddress());
    return new ResponseEntity<>(editInfoClub, HttpStatus.OK);
  }
}
