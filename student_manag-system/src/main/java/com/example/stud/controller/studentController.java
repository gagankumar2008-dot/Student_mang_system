package com.example.stud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stud.entity.Student;
import com.example.stud.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class studentController {
	
	private StudentService studentService;
	public studentController(StudentService studentService) {
      this.studentService = studentService;
   }
	
	@GetMapping
	public List<Student> liststudents(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long Id, @RequestBody Student studentDetails) {
		Student existingStudent = studentService.getStudentById(Id);
		
		existingStudent.setFirstName(studentDetails.getFirstName());
		existingStudent.setLastName(studentDetails.getLastName());
		existingStudent.setEmail(studentDetails.getEmail());
		existingStudent.setCourse(studentDetails.getCourse());
		
		return ResponseEntity.ok(studentService.updateStudent(existingStudent));
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long Id){
		studentService.deleteStudentById(Id);
		return ResponseEntity.ok("Student record deleted successfully..");
	}
}