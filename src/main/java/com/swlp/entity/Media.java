package com.swlp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Media{
	
	@JsonProperty("description")
	private String description;
	@JsonProperty("ID")
	private String id;
	@JsonProperty("ISBN")
	private String isbn;
	@JsonProperty("image")
	private String image;
	@JsonProperty("mediaType")
	private String mediaType;
	@JsonProperty("similarityValue")
	private String similarityValue;
	@JsonProperty("title")
	private String title;
	public Media() {
		super();
	}
	public Media(String id, String isbn, String description, String image, String mediaType, String similarityValue,
			String title) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.description = description;
		this.image = image;
		this.mediaType = mediaType;
		this.similarityValue = similarityValue;
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getSimilarityValue() {
		return similarityValue;
	}
	public void setSimilarityValue(String similarityValue) {
		this.similarityValue = similarityValue;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
