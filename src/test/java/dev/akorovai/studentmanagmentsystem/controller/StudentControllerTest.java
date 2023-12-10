package dev.akorovai.studentmanagmentsystem.controller;

import dev.akorovai.studentmanagmentsystem.entity.Student;
import dev.akorovai.studentmanagmentsystem.service.StudentServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentServiceInterface studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void listStudents() {
        // Arrange
        Model model = mock(Model.class);
        List<Student> students = Arrays.asList(new Student(), new Student());
        when(studentService.getAllStudents()).thenReturn(students);

        // Act
        String viewName = studentController.listStudents(model);

        // Assert
        assertThat(viewName).isEqualTo("students");
        verify(model).addAttribute(eq("students"), eq(students));
    }

    @Test
    void createStudentForm() {
        // Arrange
        Model model = mock(Model.class);

        // Act
        String viewName = studentController.createStudentForm(model);

        // Assert
        assertThat(viewName).isEqualTo("create_student");
        verify(model).addAttribute(eq("student"), any(Student.class));
    }

    @Test
    void saveStudent() {
        // Arrange
        Student student = new Student();

        // Act
        String viewName = studentController.saveStudent(student);

        // Assert
        assertThat(viewName).isEqualTo("redirect:/students");
        verify(studentService).saveStudent(student);
    }

    @Test
    void editStudentForm() {
        // Arrange
        Long studentId = 1L;
        Model model = mock(Model.class);
        Student student = new Student();
        when(studentService.getStudentById(studentId)).thenReturn(student);

        // Act
        String viewName = studentController.editStudentForm(studentId, model);

        // Assert
        assertThat(viewName).isEqualTo("edit_student");
        verify(model).addAttribute(eq("student"), eq(student));
    }

    @Test
    void updateStudent() {
        // Arrange
        Long studentId = 1L;
        Student student = new Student();
        student.setId(studentId);

        // Act
        String viewName = studentController.updateStudent(studentId, student);

        // Assert
        assertThat(viewName).isEqualTo("redirect:/students");
        verify(studentService).updateStudent(student);
    }

    @Test
    void deleteStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        String viewName = studentController.deleteStudent(studentId);

        // Assert
        assertThat(viewName).isEqualTo("redirect:/students");
        verify(studentService).deleteStudent(studentId);
    }
}
