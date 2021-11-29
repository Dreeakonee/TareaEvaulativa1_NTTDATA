package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nttdata.models.Categoria;
import com.nttdata.services.CategoriaService;

@Controller
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String categoria(@ModelAttribute("categoria") Categoria categoria,
			Model model){
		
		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		return "/categoria/categoria.jsp";
	}
	
	@RequestMapping("/crear")
	public String crearCategoria(@Valid @ModelAttribute("categoria") Categoria categoria) {
		categoriaService.insertarCategoria(categoria);
		return "redirect:/categoria";
	}
	
	
	@RequestMapping("/{id}/editar")
	public String edit(@PathVariable("id") Long id, Model model) {
		
		System.out.println("editar");
		Categoria categoria = categoriaService.buscarCategoriaId(id);
		model.addAttribute("categoria", categoria);
		return "/categoria/editarcategoria.jsp";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("categoria") Categoria categoria) {
		
		System.out.println("update");
		categoriaService.updateCategoria(categoria);
		return "redirect:/categoria";
	}
	
	

}
