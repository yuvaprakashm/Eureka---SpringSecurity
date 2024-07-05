package net.texala.eureka.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController {
	@GetMapping("/data")
	public String getData(){
		return "Hello from server Service ! ";
	}
}
