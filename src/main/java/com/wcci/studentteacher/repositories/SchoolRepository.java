package com.wcci.studentteacher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.studentteacher.models.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
    
}
