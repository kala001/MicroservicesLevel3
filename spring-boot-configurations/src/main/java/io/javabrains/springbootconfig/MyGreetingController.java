package io.javabrains.springbootconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyGreetingController {
	
	@Autowired
	private Environment env;
	
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@Value("${my.list.value}")
	private List<String> listValues;
	
	
	@Value("some static message")
	private String staticMessage;
	
	@Autowired
	private DbSettings dbSettings;
	
	@GetMapping("/greeting")
	public String greeting() {
		return dbSettings.getConnection() + dbSettings.getHost() + " message " + greetingMessage ;
	}
	
	@GetMapping("/envdetails")
	public String envdetails() {
		return env.toString() ;
	}

}
