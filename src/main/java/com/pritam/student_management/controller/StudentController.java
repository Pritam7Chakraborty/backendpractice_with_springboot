package com.pritam.student_management.controller;
import com.pritam.student_management.model.Student;
import com.pritam.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import  java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    //Get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    //Get student by ID
    @GetMapping("/{id}")
    public Optional <Student> getStudentById(@PathVariable long id){
        return studentRepository.findById(id);
    }

    //create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //update a student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id,@RequestBody Student student){
        if(studentRepository.existsById(id)){
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    //Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id)
    {
        studentRepository.deleteById(id);
    }

}
