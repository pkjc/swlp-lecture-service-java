package com.swlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swlp.entity.Lecture;
import com.swlp.service.LectureService;

@RestController
@RequestMapping("/api/lectures")
@CrossOrigin
public class LectureController {

	@Autowired
	private LectureService lectureService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Lecture> getAllLectures() {
		return lectureService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Lecture getLectureById(@PathVariable String id) {
		if(lectureService.findById(id).isPresent()){
			return lectureService.findById(id).get();
		}else{
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createNewLecture(@RequestBody Lecture lecture) {
		System.out.println("Response Body >>>  " + lecture.toString());
		//return "Done";
		lectureService.save(lecture);
		return "Done";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Lecture updateLecture(@PathVariable String id, @RequestBody Lecture lecture) {
		return lectureService.update(id, lecture);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String deleteLecture(@PathVariable String id) {
		return lectureService.delete(id);
	}
}
