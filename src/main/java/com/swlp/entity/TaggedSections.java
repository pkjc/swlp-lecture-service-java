package com.swlp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaggedSections {
	@JsonProperty("VideoId")
	private String videoId;
	@JsonProperty("VideoName")
	private String videoName;
	@JsonProperty("VideoURL")
	private String videoUrl;
	@JsonUnwrapped
	@JsonProperty("Tags")
	private List<Tags> tags;
	public TaggedSections() {
		super();
	}
	public TaggedSections(String videoId, String videoName, String videoUrl, List<Tags> tags) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.tags = tags;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
}