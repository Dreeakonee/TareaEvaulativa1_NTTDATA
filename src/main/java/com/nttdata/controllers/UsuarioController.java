package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		return "/usuario/usuario.jsp";
	}
	
	@RequestMapping("/login")
	public String login (@RequestParam("email") String email, @RequestParam("password") String password)
	{
		System.out.println(email + " "+ password);
		boolean resultado = usuarioService.loginUsuario(email,password);//IMPORTANTE!
		if(resultado) {
			return "redirect:/usuario";
		}else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping("registrarjsp")
	public String registrarjsp(@ModelAttribute("usuario")Usuario usuario) {
		
		return "/usuario/registro.jsp";
	}
	
	@RequestMapping("/registrar")//realiza insersion
	public String registrar(@Valid @ModelAttribute("usuario")Usuario usuario) {
		Usuario usuario2 = usuarioService.findByEmail(usuario.getEmail());
		if(usuario2 == null) {
			usuarioService.registroUsuario(usuario);
		}
		//usuarioService.registroUsuario(usuario);
		return "/usuario/login.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") Long id) {
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		
		if(usuario !=null) {
			usuarioService.eliminarUsuarioObjeto(usuario);
		}
		return "redirect:/usuario";
	}
	
	@RequestMapping("/{id}/editar")
	public String edit(@PathVariable("id") Long id, Model model) {
		
		System.out.println("editar");
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		model.addAttribute("usuario", usuario);
		return "/usuario/editarusuario.jsp";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("usuario") Usuario usuario) {
		
		System.out.println("update");
		usuarioService.updateUsuario(usuario);
		return "redirect:/usuario";
	}
	
	

	
}
