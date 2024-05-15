package br.com.bycoders.userservice.services;

import br.com.bycoders.userservice.domains.dto.CreateUserDto;
import br.com.bycoders.userservice.domains.entities.User;

import java.util.List;

public interface UserService {

    void createUser(CreateUserDto user);
    List<User> findAll();
}
