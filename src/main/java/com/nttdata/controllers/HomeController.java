package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "usuario/login.jsp";
	}
	//2:37:38

}
