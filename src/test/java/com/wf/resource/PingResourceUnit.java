
package com.wf.resource;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wf.server.Application;

/**
 * tausif.akram
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class PingResourceUnit {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getPing() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/ping").accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect( a -> content().string("Pong"));//content.string(equalTo("Pong")));

	}

}
