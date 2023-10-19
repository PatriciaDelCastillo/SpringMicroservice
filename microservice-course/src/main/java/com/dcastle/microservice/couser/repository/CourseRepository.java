package com.dcastle.microservice.couser.repository;

import com.dcastle.microservice.couser.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course ,Long> {
}
