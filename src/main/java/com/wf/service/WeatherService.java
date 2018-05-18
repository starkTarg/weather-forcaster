
package com.wf.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.wf.dto.WeatherResponse;
import com.wf.exception.WFException;

/**
 * tausif.akram
 */

@Repository
public class WeatherService {

	@Value("${weather.url}")
	private String baseUrl;

	@Value("${secret.key}")
	private String secretKey;

	public WeatherResponse callDarkSkyApi(String lat, String lg, String authorization) throws WFException {
		
		if(!authorization.equals(secretKey)) {
			throw new  WFException(HttpStatus.FORBIDDEN, "Authorization token is incorrect");
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl);
		uriBuilder.path("/");
		uriBuilder.path(secretKey);
		uriBuilder.path("/");
		uriBuilder.path(lat);
		uriBuilder.path(",");
		uriBuilder.path(lg);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<WeatherResponse> response = null;
		try {
			response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, WeatherResponse.class);
		} catch (Exception e) {
			System.out.println("Exception occured while calling Dark Sky" + e.getStackTrace());
		} 

		return response.getBody();

	}

}
