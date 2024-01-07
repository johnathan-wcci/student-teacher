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
@Table(name = "Teacher")
@Entity(name = "Teacher")
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "TEACHER_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastName;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String startDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private School school;

    public Teacher(String firstName, String lastName, String startDate, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.school = school;
    }
}
