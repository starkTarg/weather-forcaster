
package com.wf.resource;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * tausif.akram
 */

@Controller
public class PongResource {
	
	
	@RequestMapping(value = "/pong", method = RequestMethod.GET)
	public String pong(Map<String, Object> model) {
		model.put("message", "Hello");
		return "sample";
	}

}
