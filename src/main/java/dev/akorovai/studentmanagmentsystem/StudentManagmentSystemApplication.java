package dev.akorovai.studentmanagmentsystem;

import dev.akorovai.studentmanagmentsystem.entity.Student;
import dev.akorovai.studentmanagmentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class StudentManagmentSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagmentSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.findAll().size() < 3) {
            Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
            studentRepository.save(student1);

            Student student2 = new Student("Sanjay", "Jadhav", "sanjay@gmail.com");
            studentRepository.save(student2);

            Student student3 = new Student("Tony", "Stark", "ironman@gmail.com");
            studentRepository.save(student3);
        }

    }
}
