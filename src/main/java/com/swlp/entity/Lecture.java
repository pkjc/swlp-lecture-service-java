package com.swlp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "lectures")
public class Lecture {

	@Id
	String id;
	
	private String lectureName;
	private String lectureUrl;
	private String lectureDesc;
	private String lectureImage;
	@JsonProperty("taggedSections")
	private TaggedSections taggedSections;
	@JsonProperty("RelatedResources")
	private RelatedResources relatedResources;
	//private List<Media> media;

	public Lecture() {
		super();
	}



	public Lecture(String lectureName, String lectureUrl, String lectureDesc, String lectureImage,
			TaggedSections taggedSections, RelatedResources relatedResources) {
		super();
		this.lectureName = lectureName;
		this.lectureUrl = lectureUrl;
		this.lectureDesc = lectureDesc;
		this.lectureImage = lectureImage;
		this.taggedSections = taggedSections;
		this.relatedResources = relatedResources;
	}



	//	public Lecture(String lectureName, String lectureUrl, String lectureDesc, String lectureImage,
	//			TaggedSections taggedSections, List<Media> media) {
	//		super();
	//		this.lectureName = lectureName;
	//		this.lectureUrl = lectureUrl;
	//		this.lectureDesc = lectureDesc;
	//		this.lectureImage = lectureImage;
	//		this.taggedSections = taggedSections;
	//		this.media = media;
	//	}




	public TaggedSections getTaggedSections() {
		return taggedSections;
	}



	public RelatedResources getRelatedResources() {
		return relatedResources;
	}



	public void setRelatedResources(RelatedResources relatedResources) {
		this.relatedResources = relatedResources;
	}



	public void setTaggedSections(TaggedSections taggedSections) {
		this.taggedSections = taggedSections;
	}



//	public List<Media> getMedia() {
//		return media;
//	}
//
//
//
//	public void setMedia(List<Media> media) {
//		this.media = media;
//	}



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
