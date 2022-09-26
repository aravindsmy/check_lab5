package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Student;
import com.greatlearning.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@RequestMapping("/list")
	public String listStudent(Model model) {

		List<Student> students = studentServiceImpl.findall();
		model.addAttribute("students", students);
		return "listStudent";

	}

	@RequestMapping("/showFormforAdd")
	public String showFormforAdd(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);
		return "addStudent";
	}

	@RequestMapping("/showFormforUpdate")
	private String showFormforUpdate(@RequestParam("id") int id, Model model) {

		Student student = studentServiceImpl.findbyID(id);
		model.addAttribute("student", student);
		return "addStudent";

	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String dept, @RequestParam("country") String country) {

		Student student;
		if (id != 0) {
			student = studentServiceImpl.findbyID(id);
			student.setName(name);
			student.setDept(dept);
			student.setCountry(country);

		} else {
			student = new Student(name, dept, country);

		}

		studentServiceImpl.save(student);
		return "redirect:/student/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {

		studentServiceImpl.delete(id);
		return "redirect:/student/list";

	}
}
