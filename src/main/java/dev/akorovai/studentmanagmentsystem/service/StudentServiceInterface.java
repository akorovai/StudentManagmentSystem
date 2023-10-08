package dev.akorovai.studentmanagmentsystem.service;

import dev.akorovai.studentmanagmentsystem.entity.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    void deleteStudent(Long id);
}
