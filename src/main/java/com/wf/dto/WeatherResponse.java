
package com.wf.dto;

/**
 * tausif.akram
 */

public class WeatherResponse {

	private String latitude;
	private String longitude;
	private String timezone;
	private Currently currently;

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getTimezone() {
		return timezone;
	}

	public Currently getCurrently() {
		return currently;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public void setCurrently(Currently currently) {
		this.currently = currently;
	}

}
