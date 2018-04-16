package com.swlp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.swlp.entity.Lecture;

@Controller
@RequestMapping("/")
@CrossOrigin
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String apiUsageExamples(@RequestParam(
										name = "name", 
										required = false, 
										defaultValue = "World") 
									String name, Model model) {
		Lecture lecture = new Lecture();
		lecture.setLectureName("Works!");
		model.addAttribute("lecture", lecture);
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Lecture lecture) {
		return "result";
	}
}