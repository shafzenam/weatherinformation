package com.weatherinfo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherInformationController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String searchWeatherInfo(ModelMap model) {
		return "weatherInfo";
	}

}
