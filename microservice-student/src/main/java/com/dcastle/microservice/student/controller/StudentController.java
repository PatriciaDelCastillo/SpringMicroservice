package com.dcastle.microservice.student.controller;


import com.dcastle.microservice.student.entities.Student;
import com.dcastle.microservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student>getAllStudent(){
        return studentService.getStudent();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
         studentService.saveStudent(student);
    }

//    @GetMapping("/search/{id}")
//    public Student findById(@PathVariable  Long id){
//       return studentService.getById(id);
//    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable  Long id){
        return ResponseEntity.ok(studentService.getById(id));
    }
    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable  Long idCourse){
        return ResponseEntity.ok(studentService.getfindAllByCourseId(idCourse));
    }



}
