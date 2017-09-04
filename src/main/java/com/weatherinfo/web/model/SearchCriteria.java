package com.weatherinfo.web.model;

public class SearchCriteria {

	private String cities;

	public String getCities() {
		return cities;
	}
	
	public void setCities(String cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "SearchCriteria [cities=" + cities + "]";
	}

}
