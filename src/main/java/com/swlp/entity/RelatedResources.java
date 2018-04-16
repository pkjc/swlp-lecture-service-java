package com.swlp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedResources {
	private String relatedResTitle;
	private String relatedResDesc;
	public RelatedResources() {
		super();
	}
	public RelatedResources(String relatedResTitle, String relatedResDesc) {
		super();
		this.relatedResTitle = relatedResTitle;
		this.relatedResDesc = relatedResDesc;
	}
	public String getRelatedResTitle() {
		return relatedResTitle;
	}
	public void setRelatedResTitle(String relatedResTitle) {
		this.relatedResTitle = relatedResTitle;
	}
	public String getRelatedResDesc() {
		return relatedResDesc;
	}
	public void setRelatedResDesc(String relatedResDesc) {
		this.relatedResDesc = relatedResDesc;
	}
}
