package dev.akorovai.studentmanagmentsystem.service;

import dev.akorovai.studentmanagmentsystem.dto.UserRegistrationDto;
import dev.akorovai.studentmanagmentsystem.entity.Role;
import dev.akorovai.studentmanagmentsystem.entity.User;
import dev.akorovai.studentmanagmentsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User save(UserRegistrationDto registrationDto) {
        User newUser = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                registrationDto.getPassword(),
                List.of(new Role("USER")));
        return userRepository.save(newUser);
    }
}
