package com.docongban.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.docongban.entity.Student;
import com.docongban.repository.StudentRepository;

@Controller
public class HomeController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("")
	public String viewHome() {
		return "index";
	}

	@GetMapping("/add")
	public String addStudent(Model model, @ModelAttribute("student") Student student) {

		Optional<Student> optionalStudent=studentRepository.findById(student.getId());
		String studentS=optionalStudent.toString();
		
		if(!studentS.equals("Optional.empty")) {
			model.addAttribute("error", "Trùng mã sinh viên");
			return "index";
		}
		
		return "detail";
	}

	@PostMapping("/add")
	public String handleAddStudent(Model model, @ModelAttribute("student") Student student) {
		
		studentRepository.save(student);
		
		return "index";
	}
}
