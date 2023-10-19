package com.dcastle.microservice.couser.sevice;

import com.dcastle.microservice.couser.client.StudentClient;
import com.dcastle.microservice.couser.dto.StudentDTO;
import com.dcastle.microservice.couser.entities.Course;
import com.dcastle.microservice.couser.http.response.StudentByCourseResponse;
import com.dcastle.microservice.couser.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentClient studentClient;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }
    public Course getById(Long id){
        return courseRepository.findById(id).orElseThrow();
    }
    public Course getSave(Course course){
        return courseRepository.save(course);
    }
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse){

        //consultar el curso
        Course course=courseRepository.findById(idCourse).orElse(new Course());
        //Obtener los estudiantes
        List<StudentDTO> studentDTOList=studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .studentDTOList(studentDTOList)
                .teacher(course.getTeacher())
                .courseName(course.getName())
                .build();
    }


}
