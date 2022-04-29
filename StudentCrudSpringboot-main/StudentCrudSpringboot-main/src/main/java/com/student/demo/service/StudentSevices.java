package com.student.demo.service;

import java.util.List;

import com.student.demo.model.Student;

public interface StudentSevices {
	
	public Student createStudent(Student student);
	
    public List<Student> createStudents(List<Student> students);
	
	public Student getStudentById(String id);
	
	public List<Student> getStudents();
	
	public void updateStudent(String id, Student student);
	
	public String deleteStudentById(String id);
	
	public String deleteAll();

}
