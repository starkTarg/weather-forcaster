
package com.wf.dto;

/**
 * tausif.akram
 */

public class Currently {

	private String time;
	private String summary;
	private String icon;

	public String getTime() {
		return time;
	}

	public String getSummary() {
		return summary;
	}

	public String getIcon() {
		return icon;
	}

	public String getNearestStormDistance() {
		return nearestStormDistance;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setNearestStormDistance(String nearestStormDistance) {
		this.nearestStormDistance = nearestStormDistance;
	}

	private String nearestStormDistance;

}
