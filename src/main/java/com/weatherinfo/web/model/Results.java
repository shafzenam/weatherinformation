package com.weatherinfo.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.weatherinfo.web.jsonview.Views;

public class Results {

	@JsonView(Views.Public.class)
	private String name;

	@JsonView(Views.Public.class)
	private String city;

	@JsonView(Views.Public.class)
	private String state;

	@JsonView(Views.Public.class)
	private String country;

	@JsonView(Views.Public.class)
	private String country_iso3166;

	@JsonView(Views.Public.class)
	@JsonProperty(value = "country_name")
	private String countryName;

	@JsonView(Views.Public.class)
	private String zmw;

	@JsonView(Views.Public.class)
	private String l;

	public Results() {
	}

	public Results(String name, String city, String state, String country, String country_iso3166, String countryName,
			String zmw, String l) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.country_iso3166 = country_iso3166;
		this.countryName = countryName;
		this.zmw = zmw;
		this.l = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_iso3166() {
		return country_iso3166;
	}

	public void setCountry_iso3166(String country_iso3166) {
		this.country_iso3166 = country_iso3166;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getZmw() {
		return zmw;
	}

	public void setZmw(String zmw) {
		this.zmw = zmw;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return "Weather Details [name=" + name + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", country_iso3166=" + country_iso3166 + ", countryName=" + countryName + ", zmw=" + zmw + ", l=" + l
				+ "]";
	}

}
