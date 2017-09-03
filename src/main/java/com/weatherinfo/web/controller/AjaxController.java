package com.weatherinfo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.weatherinfo.web.delegate.WUndergroundDelegate;
import com.weatherinfo.web.jsonview.Views;
import com.weatherinfo.web.model.AjaxResponseBody;
import com.weatherinfo.web.model.SearchCriteria;
import com.weatherinfo.web.model.Results;

@RestController
public class AjaxController {

	@Autowired
	private WUndergroundDelegate wUndergroundDelegate;

	private List<Results> weatherResponse;

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();

		if (isValidSearchCriteria(search)) {
			List<Results> users = findWeatherInfo(search.getCities());

			if (users.size() > 0) {
				result.setCode("200");
				result.setMsg("");
				result.setResult(users);
			} else {
				result.setCode("204");
				result.setMsg("No user!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}

		// AjaxResponseBody will be converted into json format and send back to
		// client.
		return result;

	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.isEmpty(search.getCities()))) {
			valid = false;
		}

		return valid;
	}

	private List<Results> findWeatherInfo(String city) {

		List<Results> response = wUndergroundDelegate.getWeatherInformation(city);
		return response;

	}
}
