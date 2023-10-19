package com.dcastle.microservice.student.service;

import com.dcastle.microservice.student.entities.Student;
import com.dcastle.microservice.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getById(Long id){
        return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> getfindAllByCourseId(Long courseraId){
        return studentRepository.findAllByCourseId(courseraId);
    }
}
