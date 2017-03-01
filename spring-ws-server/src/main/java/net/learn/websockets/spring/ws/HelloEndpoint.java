package net.learn.websockets.spring.ws;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloEndpoint {

	@RequestMapping("/hello")
	public String index() {
		return "Spring-ws-server!!!";
	}

	@RequestMapping("/user/{userName}")
	@ResponseBody
	public String getUserName(@PathVariable final String userName) {
		return "User name is " + userName;
	}
}
