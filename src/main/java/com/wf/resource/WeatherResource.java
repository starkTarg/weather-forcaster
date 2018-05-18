
package com.wf.resource;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wf.dto.WeatherResponse;
import com.wf.exception.ErrorDetails;
import com.wf.exception.WFException;
import com.wf.service.WeatherService;

/**
 * tausif.akram
 */

@RestController
public class WeatherResource {

	private static final Logger logger = LoggerFactory.getLogger(WeatherResource.class);

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/weather/{coordinates}", method = RequestMethod.GET)
	public WeatherResponse getWeather(@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable("coordinates") String coordinates) throws Exception {

		logger.info("Received request to get weather");

		WeatherResponse weatherResponse = new WeatherResponse();
		String[] coordinateArr = coordinates.split(",");
		if (coordinateArr.length != 2) {
			throw new WFException(HttpStatus.BAD_REQUEST, "Latittude Longitude supplied is wrong");
		}
		String lat = coordinateArr[0];
		String lg = coordinateArr[1];
		weatherResponse = weatherService.callDarkSkyApi(lat, lg, authorization);
		return weatherResponse;
	}

}
