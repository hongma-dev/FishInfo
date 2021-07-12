package com.fish.hongma.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloClass {

	
	
	@GetMapping(value="/hello")
	public String helloMethod() {
		
		return "hello";
	}
}
