package com.server.sport.service;

import com.server.sport.model.InfoClub;

public interface InfoClubService {
  InfoClub getInfoClub();
  InfoClub editInfoClub(String newTitle, String newDescription, String newPhone, String newAddress);
}
