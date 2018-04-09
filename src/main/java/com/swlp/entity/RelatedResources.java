package com.swlp.entity;

public class RelatedResources {
	private String relatedResTitle;
	private String relatedResDesc;
	public RelatedResources() {
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
