package br.com.bycoders.userservice.services.impl;

import br.com.bycoders.userservice.domains.dto.CreateUserDto;
import br.com.bycoders.userservice.domains.entities.User;
import br.com.bycoders.userservice.repositories.UserRepository;
import br.com.bycoders.userservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper mapper,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(CreateUserDto user) {
        userRepository.save(User.builder().username(user.username()).password(passwordEncoder.encode(user.password())).build());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
