package com.server.sport.auth;

import com.server.sport.config.JwtService;
import com.server.sport.user.Role;
import com.server.sport.user.User;
import com.server.sport.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository repository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder().
        email(request.getEmail()).
        password(passwordEncoder.encode(request.getPassword())).
        surname(request.getSurname()).
        name(request.getName()).
        birthDate(request.getBirthDate()).
        category(request.getCategory()).
        role(Role.SPORTSMEN)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = repository.findByEmail(request.getEmail()).orElseThrow();
    var token = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(token).build();
  }
}
