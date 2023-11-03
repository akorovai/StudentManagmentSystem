package dev.akorovai.studentmanagmentsystem.service;

import dev.akorovai.studentmanagmentsystem.dto.UserRegistrationDto;
import dev.akorovai.studentmanagmentsystem.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserServiceInterface extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
