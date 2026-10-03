package com.example.stud.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.stud.entity.Student;
import com.example.stud.repository.StudentRepository;
import com.example.stud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long Id) {
		return studentRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Student" + "not found with id:" + Id));
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long Id) {
		studentRepository.deleteById(Id);
	}

	
}