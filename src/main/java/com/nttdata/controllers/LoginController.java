package com.nttdata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario, Model model){
		
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "/login/login.jsp";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("nombre")String nombre, @ModelAttribute("usuario") Usuario usuario, Model model) {
		List<Usuario> listaUsuariosLogin = usuarioService.obtenerUsuarioWhereIdSQL(nombre);	
		System.out.println(nombre);
		for (int i = 0; i < listaUsuariosLogin.size(); i++) {
			if(nombre.equals(listaUsuariosLogin.get(i).getNombre())) {
				return "redirect:/producto";
			}
		}
		return "redirect:/login";
	
	}
}
