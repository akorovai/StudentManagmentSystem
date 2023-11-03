package dev.akorovai.studentmanagmentsystem.service;

import dev.akorovai.studentmanagmentsystem.dto.UserRegistrationDto;
import dev.akorovai.studentmanagmentsystem.entity.User;


public interface UserServiceInterface {
    User save(UserRegistrationDto registrationDto);
}
