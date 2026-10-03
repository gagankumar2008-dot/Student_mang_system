package com.example.stud.service;

import java.util.List;

import com.example.stud.entity.Student;

public interface StudentService {
	List<Student> getAllStudent();
	Student saveStudent(Student student);
	Student getStudentById(Long Id);
	Student updateStudent(Student student);
	void deleteStudentById(Long Id);


}
