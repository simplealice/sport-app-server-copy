package com.server.sport.user;

import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUser(String email) {
    return userRepository.findByEmail(email).orElseThrow(
        () -> new UsernameNotFoundException("User not found")
    );
  }
}
