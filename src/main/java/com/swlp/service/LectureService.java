package com.swlp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swlp.entity.Lecture;
import com.swlp.entity.RelatedResources;
import com.swlp.entity.TaggedSections;
import com.swlp.entity.Tags;
import com.swlp.repository.LectureRepository;

@Service
public class LectureService {

	@Autowired
	private LectureRepository lectureRepository;
	
	static ArrayList<Map<String, String>> mpList = new ArrayList<>();
	
	static Map<String, String> mp = new HashMap<>();
	
	static{ 
		mp.put("5ad51be90b2da83c29b38e4b", "c4c1ad4c9a");
		mpList.add(mp);
		mp.put("5ad51ca20b2da83c29b38e4c", "ed6ede78ad");
		mpList.add(mp);
		mp.put("5ad51cc00b2da83c29b38e4d", "c177fae461");
		mpList.add(mp);
	}

	public Iterable<Lecture> findAll() {
		
		Iterable<Lecture> lectures = lectureRepository.findAll();
		int i = 0;
		for (Lecture lecture : lectures) {
			lecture.setTaggedSections(getLectureTags(mpList.get(i).get(lecture.getId())));  
			i++;
		}

		return lectures;
	}

	public Optional<Lecture> findById(String id) {
		Optional<Lecture> lecture = lectureRepository.findById(id);

		// Get tags for this video
		if (lecture.isPresent()) {
			for(Map<String, String> mp: mpList){
				if(mp.containsKey(id)){
					lecture.get().setTaggedSections(getLectureTags(mp.get(id)));
				}
			}
			
			List<Tags> tags = lecture.get().getTaggedSections().getTags();
			lecture.get().setRelatedResources((getRelatedResources(id, tags)));
		}

		return lecture;
	}

	public Lecture save(Lecture lecture) {
		return lectureRepository.save(lecture);
	}

	public Lecture update(String id, Lecture lectureUpdated) {
		Optional<Lecture> lectureFromDB = lectureRepository.findById(id);

		if (lectureFromDB.isPresent() && lectureUpdated != null) {
			if (lectureUpdated.getLectureName() != null) {
				lectureFromDB.get().setLectureName(lectureUpdated.getLectureName());
			}
			if (lectureUpdated.getLectureDesc() != null) {
				lectureFromDB.get().setLectureDesc(lectureUpdated.getLectureDesc());
			}
			if (lectureUpdated.getLectureUrl() != null) {
				lectureFromDB.get().setLectureUrl(lectureUpdated.getLectureUrl());
			}
			if (lectureUpdated.getLectureImage() != null) {
				lectureFromDB.get().setLectureImage(lectureUpdated.getLectureImage());
			}
			return lectureRepository.save(lectureFromDB.get());
		} else {
			return null;
		}
	}

	public String delete(String id) {
		Optional<Lecture> lectureFromDB = lectureRepository.findById(id);
		if (lectureFromDB.isPresent()) {
			lectureRepository.delete(lectureFromDB.get());
			return "Lecture Deleted!";
		} else {
			return "Lecture Not Found";
		}
	}

	public RelatedResources getRelatedResources(String vidId, List<Tags> tags) {

		final String uri = "https://swlp-resources-service.herokuapp.com/relatedresources/get";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("tags", tags.get(0).getTagName());
		httpHeaders.set("limit", "2");
		httpHeaders.set("key", "csi5510swlp");

		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

		ResponseEntity<RelatedResources> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity,
				RelatedResources.class);

		System.out.println("response.getStatusCode() - > " + response.getStatusCode() + "response.hasBody() - > "
				+ response.getBody());

		return response.getBody();
	}

	public TaggedSections getLectureTags(String vidIdFromTag) {

		final String uri = "http://videometadataawd20180410025538.azurewebsites.net/api/MetatagsController/"+ vidIdFromTag;
		
		System.out.println("URL - > " + uri);
		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<TaggedSections> response = restTemplate.getForEntity(uri, TaggedSections.class);
		
		System.out.println("response.getStatusCode() - > " + response.getStatusCodeValue());

		return response.getBody();
	}

}

@Configuration
class AppConfig {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.setConnectTimeout(120000).build();
	}
}
