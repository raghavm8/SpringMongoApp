package org.raghav.springreactmongoapp.Controllers;

import org.raghav.springreactmongoapp.Models.Student;
import org.raghav.springreactmongoapp.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/AddStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/UpdateStudent/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/DeleteStudent/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
}
