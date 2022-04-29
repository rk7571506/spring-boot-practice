package com.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.student.demo.model.Student;
import com.student.demo.service.StudentSevices;
import com.student.demo.util.StudentConstant;

@RestController
@RequestMapping(StudentConstant.Api)
public class StudentRestController {
	
	@Autowired
	private StudentSevices studentService;
	
	@PostMapping(StudentConstant.AddStudent)
	public Student addUser(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PostMapping(StudentConstant.AddStudents)
	public List<Student> addUsers(@RequestBody List<Student> students) {
		return studentService.createStudents(students);
	}

	@GetMapping(StudentConstant.Student +"/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}

	@GetMapping(StudentConstant.Students)
	public List<Student> getAllStudents() {
		return studentService.getStudents();
	}
	
	@PutMapping(StudentConstant.Student +"/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
		return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
	}
	
	@DeleteMapping(StudentConstant.Student +"/{id}")
	public String deleteStudentById(@PathVariable String id) {
		return studentService.deleteStudentById(id);
	}
	
	@DeleteMapping(StudentConstant.Students)
	public String deleteAll() {
		return studentService.deleteAll();
	}

}
