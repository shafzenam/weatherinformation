package com.weatherinfo.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.weatherinfo.web.delegate.WUndergroundDelegate;
import com.weatherinfo.web.jsonview.Views;
import com.weatherinfo.web.model.AjaxResponseBody;
import com.weatherinfo.web.model.Results;
import com.weatherinfo.web.model.SearchCriteria;

@RestController
public class AjaxController {
	
	 private static Logger LOGGER = Logger.getLogger(AjaxController.class);

	@Autowired
	private WUndergroundDelegate wUndergroundDelegate;

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();

		if (isValidSearchCriteria(search)) {
			List<Results> response = findWeatherInfo(search.getCities());
			
			if(null == response || response.isEmpty()){
				result.setCode("500");
				result.setMsg("Invalid City Name. Not found !!");
				LOGGER.error("Invalid City Name: " + search.getCities());
			}

			else if (response.size() > 0) {
				result.setCode("200");
				result.setMsg("");
				result.setResult(response);
			} else {
				result.setCode("204");
				result.setMsg("No weather information found!!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!!");
			LOGGER.warn("Empty search criteria.");
		}

		return result;

	}

	private boolean isValidSearchCriteria(final SearchCriteria search) {
		if ((StringUtils.isBlank(search.getCities()))) {
			return false;
		}
		return true;
	}

	private List<Results> findWeatherInfo(final String city) {

		List<Results> response = wUndergroundDelegate.getWeatherInformation(city);
		return response;

	}
}
