package com.dilemme.server;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Run {


	@RequestMapping("/")
	public String welcome(){
	    return "Please come later the web site is in building ! (- ";
	}

}
