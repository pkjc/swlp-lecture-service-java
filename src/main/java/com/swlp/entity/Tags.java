package com.swlp.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tags {
	@JsonProperty("tagName")
	public String tagName;
	@JsonUnwrapped
	@JsonProperty("Appearances")
	public List<Appearances> appearances;
	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tags(String tagName, List<Appearances> appearances) {
		super();
		this.tagName = tagName;
		this.appearances = appearances;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public List<Appearances> getAppearances() {
		return appearances;
	}
	public void setAppearances(List<Appearances> appearances) {
		this.appearances = appearances;
	}
}
