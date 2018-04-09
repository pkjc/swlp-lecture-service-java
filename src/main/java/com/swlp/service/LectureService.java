package com.swlp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swlp.entity.Lecture;
import com.swlp.repository.LectureRepository;

@Service
public class LectureService {

	@Autowired
	private LectureRepository lectureRepository;

	public Iterable<Lecture> findAll() {
		return lectureRepository.findAll();
	}

	public Optional<Lecture> findById(String id) {
		return lectureRepository.findById(id);
	}

	public Lecture save(Lecture lecture) {
		return lectureRepository.save(lecture);
	}

	public Lecture update(String id, Lecture lectureUpdated) {
		Optional<Lecture> lectureFromDB = lectureRepository.findById(id);

		if(lectureFromDB.isPresent() && lectureUpdated != null){
			if(lectureUpdated.getLectureName() != null){
				lectureFromDB.get().setLectureName(lectureUpdated.getLectureName());
			}
			if(lectureUpdated.getLectureDesc() != null){
				lectureFromDB.get().setLectureDesc(lectureUpdated.getLectureDesc());
			}
			if(lectureUpdated.getLectureUrl() != null){
				lectureFromDB.get().setLectureUrl(lectureUpdated.getLectureUrl());
			}
			if(lectureUpdated.getLectureImage() != null){
				lectureFromDB.get().setLectureImage(lectureUpdated.getLectureImage());
			}
			return lectureRepository.save(lectureFromDB.get());
		}else {
			return null;
		}
	}

	public String delete(String id) {
		Optional<Lecture> lectureFromDB = lectureRepository.findById(id);
		if(lectureFromDB.isPresent()){
			lectureRepository.delete(lectureFromDB.get());
			return "Lecture Deleted!";
		}else{
			return "Lecture Not Found";
		}
	}
}
