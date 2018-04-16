package com.swlp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swlp.entity.Lecture;
import com.swlp.entity.Media;
import com.swlp.entity.TaggedSections;
import com.swlp.repository.LectureRepository;

@Service
public class LectureService {

	@Autowired
	private LectureRepository lectureRepository;

	public Iterable<Lecture> findAll() {
		Iterable<Lecture> lectures = lectureRepository.findAll();
		
		return lectures;
	}

	public Optional<Lecture> findById(String id) {
		Optional<Lecture> lecture = lectureRepository.findById(id);
		
		//Get tags for this video
		if(lecture.isPresent()){
			lecture.get().setTaggedSections(getLectureTags(id));
		}
		
		//Get related resources for the returned tags
		if(lecture.isPresent()){
			lecture.get().setMedia((getRelatedResources(id)));
		}
		return lecture;
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

	public List<Media> getRelatedResources(String vidId){
		
		final String uri = "https://swlp-resources-service.herokuapp.com/relatedresources/get/";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.set("tags", "object oriented programming language");
	    httpHeaders.set("limit", "2");
	    httpHeaders.set("key", "csi5510swlp");
	    
	    HttpEntity <String> httpEntity = new HttpEntity <String> (httpHeaders);
	    
	    ResponseEntity<List<Media>> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Media>>() {});
	     
	    System.out.println("response.getStatusCode() - > " 
	    + response.getStatusCode() 
	    + "response.hasBody() - > " + response.getBody());
		
		return response.getBody();
	}

	public TaggedSections getLectureTags(String vidId){
		
		final String uri = "http://videometadataawd20180410025538.azurewebsites.net/api/ValuesController/08da529a3f";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    
	    ResponseEntity<TaggedSections> response = 
	    		restTemplate.exchange(uri, HttpMethod.GET, null,TaggedSections.class);
	     
	    System.out.println("response.getStatusCode() - > " 
	    + response.getStatusCode() 
	    + "response.hasBody() - > " + response.getBody());
		
		return response.getBody();
	}
}
