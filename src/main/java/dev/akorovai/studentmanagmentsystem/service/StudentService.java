package dev.akorovai.studentmanagmentsystem.service;

import dev.akorovai.studentmanagmentsystem.entity.Student;
import dev.akorovai.studentmanagmentsystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StudentService implements StudentServiceInterface {

    private final StudentRepository studentRepository;


    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found for id: " + id));
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {

        getStudentById(student.getId());
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}

