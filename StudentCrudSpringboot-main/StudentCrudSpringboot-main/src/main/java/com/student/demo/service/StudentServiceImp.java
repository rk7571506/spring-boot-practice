package com.student.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.util.MessageConstant;
import com.student.demo.dao.StudentRepository;
import com.student.demo.model.Student;

@Service
public class StudentServiceImp implements StudentSevices {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> createStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	@Override
	public Student getStudentById(String id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void updateStudent(String id, Student student) {
		Student studentUpdate = studentRepository.findById(id).get();
		System.out.println(studentUpdate.toString());
		studentUpdate.setFirstName(student.getFirstName());
		studentUpdate.setLastName(student.getLastName());
		studentUpdate.setAddress(student.getAddress());
		studentUpdate.setPincode(student.getPincode());
		studentUpdate.setMobileNumber(student.getMobileNumber());
		studentUpdate.setEmail(student.getEmail());
		
		studentRepository.save(studentUpdate);
	}

	@Override
	public String deleteStudentById(String id) {
		studentRepository.deleteById(id);
		return MessageConstant.delete;
	}

	@Override
	public String deleteAll() {
		studentRepository.deleteAll();
		return MessageConstant.deleteAll;
	}
	
}
