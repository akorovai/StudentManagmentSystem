package dev.akorovai.studentmanagmentsystem.controller;

import dev.akorovai.studentmanagmentsystem.entity.Student;
import dev.akorovai.studentmanagmentsystem.service.StudentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceInterface studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        student.setId(id);  // Ensure the ID from the path is set
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}

