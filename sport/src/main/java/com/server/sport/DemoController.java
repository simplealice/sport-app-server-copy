package com.server.sport;

import ch.qos.logback.classic.Logger;
import com.server.sport.user.User;
import com.server.sport.user.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

  UserService userService;
  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from serv");
  }

  @GetMapping("/users")
  public ResponseEntity<?> listUsers() {
    List<User> resource = userService.getUsers();
    return ResponseEntity.ok(resource);
  }
}
