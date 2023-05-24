package com.server.sport.service;

import com.server.sport.model.InfoClub;
import com.server.sport.repository.InfoClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InfoClubServiceImpl implements InfoClubService {

  @Autowired
  private InfoClubRepository infoClubRepository;

  @Override
  public InfoClub getInfoClub() {
    return infoClubRepository.findById(1).orElseThrow(
        () -> new UsernameNotFoundException("Info club not found")
    );
  }

  @Override
  public InfoClub editInfoClub(String newTitle, String newDescription, String newPhone,
      String newAddress) {
    InfoClub infoClub = infoClubRepository.getReferenceById(1);
    if (newTitle != null) {
      infoClub.setTitle(newTitle);
    }
    if (newDescription != null) {
      infoClub.setDescription(newDescription);
    }
    if (newPhone != null) {
      infoClub.setPhone(newPhone);
    }
    if (newAddress != null) {
      infoClub.setAddress(newAddress);
    }
    return infoClubRepository.save(infoClub);
  }
}
