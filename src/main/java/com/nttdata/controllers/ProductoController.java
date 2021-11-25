package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Producto;
import com.nttdata.services.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@RequestMapping("")
	public String producto(@ModelAttribute("producto") Producto producto,
			Model model){
		
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		return "producto.jsp";
	}
	
	@RequestMapping("/agregarproducto")
	public String agregarproducto (@Valid @ModelAttribute("producto") Producto producto)
	{
		System.out.println(producto.getNombre() + " " + producto.getDescripcion() + " " + producto.getPrecio());
		productoService.insertarProducto(producto);//IMPORTANTE!
		return "redirect:/producto";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarProducto(@RequestParam("id") Long id) {
		Producto producto = productoService.buscarProductoId(id);
		
		if(producto !=null) {
			productoService.eliminarProductoObjeto(producto);
		}
		return "redirect:/producto";
	}
}
