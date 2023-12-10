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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentServiceInterface studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void listStudents() {
        Model model = mock(Model.class);
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(new Student(), new Student()));

        String viewName = studentController.listStudents(model);

        assertThat(viewName).isEqualTo("students");
        verify(model).addAttribute(eq("students"), anyList());
    }

    @Test
    void createStudentForm() {
        Model model = mock(Model.class);

        String viewName = studentController.createStudentForm(model);

        assertThat(viewName).isEqualTo("create_student");
        verify(model).addAttribute(eq("student"), any(Student.class));
    }

    @Test
    void saveStudent() {
        Student student = new Student();

        String viewName = studentController.saveStudent(student);

        assertThat(viewName).isEqualTo("redirect:/students");
        verify(studentService).saveStudent(student);
    }

    @Test
    void editStudentForm() {
        Long studentId = 1L;
        Model model = mock(Model.class);
        when(studentService.getStudentById(studentId)).thenReturn(new Student());

        String viewName = studentController.editStudentForm(studentId, model);

        assertThat(viewName).isEqualTo("edit_student");
        verify(model).addAttribute(eq("student"), any(Student.class));
    }

    @Test
    void updateStudent() {
        Long studentId = 1L;
        Student student = new Student();
        student.setId(studentId);

        String viewName = studentController.updateStudent(studentId, student);

        assertThat(viewName).isEqualTo("redirect:/students");
        verify(studentService).updateStudent(student);
    }

    @Test
    void deleteStudent() {
        Long studentId = 1L;

        String viewName = studentController.deleteStudent(studentId);

        assertThat(viewName).isEqualTo("redirect:/students");
        verify(studentService).deleteStudent(studentId);
    }
}
