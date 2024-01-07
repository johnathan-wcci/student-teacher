package com.wcci.studentteacher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcci.studentteacher.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> getBySchoolId(Integer schoolId);
}
