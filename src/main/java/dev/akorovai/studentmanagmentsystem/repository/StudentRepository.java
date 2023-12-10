package dev.akorovai.studentmanagmentsystem.repository;

import dev.akorovai.studentmanagmentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}
