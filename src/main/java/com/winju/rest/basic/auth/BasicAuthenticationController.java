package com.winju.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {

	@GetMapping(path="/basicauth")
	public AuthenticationBean basicAuth() {
		return new AuthenticationBean("You are authenticated" );
	}
}
