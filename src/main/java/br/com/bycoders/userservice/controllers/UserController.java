package br.com.bycoders.userservice.controllers;

import br.com.bycoders.userservice.domains.dto.CreateUserDto;
import br.com.bycoders.userservice.domains.entities.User;
import br.com.bycoders.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {

   private final UserService userService;

   @Autowired
   public UserController(UserService userService) {
      this.userService = userService;
   }

   @PostMapping
   public ResponseEntity<Void> createUser(@RequestBody CreateUserDto user) {
      userService.createUser(user);
      return ResponseEntity.ok().build();
   }

   @GetMapping
   public ResponseEntity<List<User>> getAll() {
      return ResponseEntity.ok(userService.findAll());
   }
}
