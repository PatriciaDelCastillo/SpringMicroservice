package com.dcastle.microservice.couser.controller;

import com.dcastle.microservice.couser.entities.Course;
import com.dcastle.microservice.couser.sevice.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    private List<Course> getCourseAll(){
        return courseService.getAll();
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course){
        courseService.getSave(course);
    }

    //    @GetMapping("/search/{id}")
//    public Course findById(@PathVariable  Long id){
//       return courseService.getById(id);
//    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable  Long id){
        return ResponseEntity.ok(courseService.getById(id));
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(courseService.findStudentByIdCourse(idCourse));
    }

}
