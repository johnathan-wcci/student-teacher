package com.wcci.studentteacher.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "School")
@Entity(name = "School")
@NoArgsConstructor  // This is the default constructor. It is necessary for SpringBoot.
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "SCHOOL_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Integer id;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String schoolName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String schoolState;

    public School(String schoolName, String schoolState) {
        this.schoolName = schoolName;
        this.schoolState = schoolState;
    }
}
