package com.weatherinfo.web.delegate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weatherinfo.web.model.Results;
import com.weatherinfo.web.model.WUndergroundResponse;

@Component
public class WUndergroundDelegate {

	final String endpoint_uri = "http://api.wunderground.com/api/0febb2c6dfdd1e46/conditions/q/";

	public List<Results> getWeatherInformation(final String city) {

		final String uri = endpoint_uri + city + ".json";
		RestTemplate restTemplate = new RestTemplate();
		WUndergroundResponse response = restTemplate.getForObject(uri, WUndergroundResponse.class);

		return response.getResponse().getResults();

	}

}
