package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.studentRepository;

@Service
public class StudentService implements StudentServiced {

	@Autowired
	private studentRepository studentRepo;
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	public Student getStudentById(Long id){
		return studentRepo.findById(id).orElse(null);
	}
	public void saveStudent(Student student){
		studentRepo.save(student);
	}
	
	public void deleteStudentById(Long id){
		studentRepo.deleteById(id);
	}
	
}
