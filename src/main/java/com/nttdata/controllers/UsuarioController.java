package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario,
			Model model){
		
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "usuario.jsp";
	}
	
	@RequestMapping("/login")
	public String login (@Valid @ModelAttribute("usuario") Usuario usuario)
	{
		System.out.println(usuario.getNombre() + " " + usuario.getApellido() + " " + usuario.getEdad() + " " + usuario.getEmail());
		usuarioService.insertarUsuario(usuario);//IMPORTANTE!
		return "redirect:/usuario";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") Long id) {
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		
		if(usuario !=null) {
			usuarioService.eliminarUsuarioObjeto(usuario);
		}
		//usuarioService.eliminarUsuario(id);
		return "redirect:/usuario";
	}
}