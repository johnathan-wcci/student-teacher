package com.wcci.studentteacher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.studentteacher.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>  {
    List<Student> getByTeacherId(Integer teacherId);
    List<Student> getBySchoolId(Integer schoolId);
}
