package com.swlp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedResources {
//	private String relatedResTitle;
//	private String relatedResDesc;
	@JsonUnwrapped
	@JsonProperty("media")
	private List<Media> media;
	
	public RelatedResources() {
		super();
	}

	public RelatedResources(List<Media> media) {
		super();
//		this.relatedResTitle = relatedResTitle;
//		this.relatedResDesc = relatedResDesc;
		this.media = media;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}


//	public String getRelatedResTitle() {
//		return relatedResTitle;
//	}
//	public void setRelatedResTitle(String relatedResTitle) {
//		this.relatedResTitle = relatedResTitle;
//	}
//	public String getRelatedResDesc() {
//		return relatedResDesc;
//	}
//	public void setRelatedResDesc(String relatedResDesc) {
//		this.relatedResDesc = relatedResDesc;
//	}
}
