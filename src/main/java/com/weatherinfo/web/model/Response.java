package com.weatherinfo.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.weatherinfo.web.jsonview.Views;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	@JsonView(Views.Public.class)
	@JsonProperty(value = "results")
	private List<Results> results;

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}
}
