
package com.wf.exception;

import org.springframework.http.HttpStatus;

/**
 * tausif.akram
 */

public class WFException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WFException(HttpStatus status, String message) {
		super(new StringBuilder().append(message).append(",").append(status).toString());
	}

}
