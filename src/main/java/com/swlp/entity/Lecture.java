package com.swlp.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lectures")
public class Lecture {

	@Id
	String id;
	private String lectureName;
	private String lectureUrl;
	private String lectureDesc;
	private String lectureImage;
	private TaggedSections taggedSections;
	private List<Media> media;

	public Lecture() {
		super();
	}

	

	public Lecture(String lectureName, String lectureUrl, String lectureDesc, String lectureImage,
			TaggedSections taggedSections, List<Media> media) {
		super();
		this.lectureName = lectureName;
		this.lectureUrl = lectureUrl;
		this.lectureDesc = lectureDesc;
		this.lectureImage = lectureImage;
		this.taggedSections = taggedSections;
		this.media = media;
	}
	
	


	public TaggedSections getTaggedSections() {
		return taggedSections;
	}



	public void setTaggedSections(TaggedSections taggedSections) {
		this.taggedSections = taggedSections;
	}



	public List<Media> getMedia() {
		return media;
	}



	public void setMedia(List<Media> media) {
		this.media = media;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureUrl() {
		return lectureUrl;
	}

	public void setLectureUrl(String lectureUrl) {
		this.lectureUrl = lectureUrl;
	}

	public String getLectureDesc() {
		return lectureDesc;
	}

	public void setLectureDesc(String lectureDesc) {
		this.lectureDesc = lectureDesc;
	}

	public String getLectureImage() {
		return lectureImage;
	}

	public void setLectureImage(String lectureImage) {
		this.lectureImage = lectureImage;
	}
}
