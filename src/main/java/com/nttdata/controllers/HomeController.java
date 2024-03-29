package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;

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
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute("usuario") Usuario usuario){
		return "usuario/registro.jsp";
	}
	//2:50:14

}
