package dev.akorovai.studentmanagmentsystem.repository;

import dev.akorovai.studentmanagmentsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}