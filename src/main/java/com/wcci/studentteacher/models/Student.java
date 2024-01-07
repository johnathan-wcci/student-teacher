package com.wcci.studentteacher.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Student")
@Entity(name = "Student")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private Integer age;

    @Column(nullable = false, columnDefinition = "DOUBLE")
    private double gpa;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String graduationDate;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private School school;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Teacher teacher;

    public Student(String firstName, String lastName, String graduationDate, School school, Teacher teacher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = 18;
        this.gpa = 4.0;
        this.graduationDate = graduationDate;
        this.teacher = teacher;
        this.school = school;
    }
}
