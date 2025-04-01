package com.pritam.student_management.controller;
import com.pritam.student_management.model.Student;
import com.pritam.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import  java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    //Get student by ID
    @GetMapping("/{id}")
    public Optional <Student> getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    //create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //update a student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id,@RequestBody Student student){
     return studentService.updateStudent(id,student);
    }

    //Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id)
    {
        studentService.deleteStudent(id);
    }
}
