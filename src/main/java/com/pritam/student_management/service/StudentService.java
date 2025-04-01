package com.pritam.student_management.service;

import com.pritam.student_management.model.Student;
import com.pritam.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //add a student
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //Get student by ID
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }
    //Delete student
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    //update student
    public Student updateStudent(Long id, Student student){
        if (studentRepository.existsById(id)){
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

}
