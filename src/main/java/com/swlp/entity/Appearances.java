package com.swlp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appearances {
	@JsonProperty("startTime")
	private String startTime;
	@JsonProperty("endTime")
	private String endTime;
	public Appearances() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appearances(String startTime, String endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
