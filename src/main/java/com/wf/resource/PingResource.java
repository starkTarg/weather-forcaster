package com.wf.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * tausif.akram
 */

@RestController
public class PingResource {

	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "Pong";
	}

}
