package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentServiced {
List<Student> getAllStudents();
Student getStudentById(Long id);
void saveStudent(Student student);
void deleteStudentById(Long id);
}
