package dev.akorovai.studentmanagmentsystem.service;

import dev.akorovai.studentmanagmentsystem.entity.Student;
import dev.akorovai.studentmanagmentsystem.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void getAllStudents() {
        when(studentRepository.findAll()).thenReturn(Arrays.asList(new Student(), new Student()));

        List<Student> students = studentService.getAllStudents();

        assertEquals(2, students.size());
    }

    @Test
    void saveStudent() {
        Student student = new Student();

        studentService.saveStudent(student);

        verify(studentRepository).save(student);
    }

    @Test
    void getStudentById() {
        Long studentId = 1L;
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(new Student()));

        Student student = studentService.getStudentById(studentId);

        assertNotNull(student);
    }

    @Test
    void updateStudent() {
        Student student = new Student();
        student.setId(1L);

        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));

        studentService.updateStudent(student);

        verify(studentRepository).save(student);
    }

    @Test
    void deleteStudent() {
        Long studentId = 1L;
        Student student = new Student();
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        studentService.deleteStudent(studentId);

        verify(studentRepository).delete(student);
    }
}
