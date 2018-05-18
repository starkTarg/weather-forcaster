package com.wf.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wf.dto.PingResponse;

/**
 * tausif.akram
 */

@RestController
public class PingResource {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public PingResponse ping() {
		PingResponse pingResponse = new PingResponse();
		pingResponse.setStatus("Pong");
		return pingResponse;
	}

}
