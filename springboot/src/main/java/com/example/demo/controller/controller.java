package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class controller {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("students", studentservice.getAllStudents());
		return "students";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("student", new Student());
		return "add-student";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		System.out.println(student.getId());
		studentservice.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentservice.getStudentById(id));
		return "add-student";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		studentservice.deleteStudentById(id);
		return "redirect:/";

	}

}
