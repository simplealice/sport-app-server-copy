package com.server.sport.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

//  @PostMapping("/add")
//  public String add(@RequestBody Coach coach) {
//    userService.saveCoach(coach);
//    return "Добавлен новый тренер";
//  }

  @GetMapping("/getAll")
  public List<User> getAllUsers() {
    return userService.getUsers();
  }

  @PostMapping(value = "/get/{email}")
  public User getUser(@PathVariable("email") String email) {
    return userService.getUser(email);
  }

//  @GetMapping(value = "/delete/{id}")
//  public String delete(@PathVariable("id") long id) {
//    userService.deleteById(id);
//    return "Удален тренер " + id;
//  }
}
