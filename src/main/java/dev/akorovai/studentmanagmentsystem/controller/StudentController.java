package dev.akorovai.studentmanagmentsystem.controller;

import dev.akorovai.studentmanagmentsystem.entity.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dev.akorovai.studentmanagmentsystem.service.StudentServiceInterface;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/students")
public class StudentController {
    private final StudentServiceInterface studentServiceInterface;
    @GetMapping
    public String listStudents(Model model){
        System.out.println();
        model.addAttribute("students", studentServiceInterface.getAllStudents());
        return "students";
    }
    @GetMapping("/new")
    public String createStudentForm(Model model){
        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student){
        studentServiceInterface.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentServiceInterface.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/{id}")
    @Transactional
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model){
        // get student from db by id

        Student existingStudent = studentServiceInterface.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentServiceInterface.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentServiceInterface.deleteStudent(id);
        return "redirect:/students";
    }
}
