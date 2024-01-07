CREATE TABLE school (id INTEGER NOT NULL AUTO_INCREMENT, school_name TEXT NOT NULL, school_state TEXT NOT NULL, PRIMARY KEY (id));
CREATE TABLE teacher (id INTEGER NOT NULL AUTO_INCREMENT, school_id integer NOT NULL, first_name TEXT NOT NULL, last_name TEXT NOT NULL, start_date TEXT NOT NULL, PRIMARY KEY (id));
CREATE TABLE student (id INTEGER NOT NULL AUTO_INCREMENT, age INTEGER NOT NULL, gpa DOUBLE NOT NULL, school_id INTEGER NOT NULL, teacher_id INTEGER NOT NULL, first_name TEXT NOT NULL, graduation_date TEXT NOT NULL, last_name TEXT NOT NULL, PRIMARY KEY (id));

CREATE SEQUENCE SCHOOL_SEQ START WITH 3 INCREMENT BY 1;
CREATE SEQUENCE TEACHER_SEQ START WITH 3 INCREMENT BY 1;
CREATE SEQUENCE STUDENT_SEQ START WITH 7 INCREMENT BY 1;

INSERT INTO school (id, school_name, school_state) VALUES (1, 'Massachusetts Institute of Technology', 'Massachusetts');
INSERT INTO school (id, school_name, school_state) VALUES (2, 'Harvard University', 'Massachusetts');

INSERT INTO teacher (id, first_name, last_name, start_date, school_id) VALUES (1, 'John', 'Alexander', '2024', 1);
INSERT INTO teacher (id, first_name, last_name, start_date, school_id) VALUES (2, 'Nick', 'Fury', '2008', 2);

INSERT INTO student (id, first_name, last_name, age, gpa, graduation_date, school_id, teacher_id) VALUES (1, 'Peter', 'Parker', 18, 3.7, 2024, 1, 1);
INSERT INTO student (id, first_name, last_name, age, gpa, graduation_date, school_id, teacher_id) VALUES (2, 'Tony', 'Stark', 54, 4.0, 2023, 1, 1);
INSERT INTO student (id, first_name, last_name, age, gpa, graduation_date, school_id, teacher_id) VALUES (3, 'Loki', 'Odinson', 1059, 2.0, 2020, 2, 2);
INSERT INTO student (id, first_name, last_name, age, gpa, graduation_date, school_id, teacher_id) VALUES (4, 'Stephen', 'Strange', 61, 4.0, 2025, 2, 2);
INSERT INTO student (id, first_name, last_name, age, gpa, graduation_date, school_id, teacher_id) VALUES (5, 'Bruce', 'Banner', 55, 3.6, 2019, 1, 1);
INSERT INTO student (id, first_name, last_name, age, gpa, graduation_date, school_id, teacher_id) VALUES (6, 'Natasha', 'Romanoff', 32, 3.0, 2025, 2, 2);
