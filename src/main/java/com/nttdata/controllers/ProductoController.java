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

import com.nttdata.models.Producto;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String producto(@ModelAttribute("producto") Producto producto,
			Model model){
		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		return "/producto/producto.jsp";
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
	
	@RequestMapping("/{id}/editar")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		System.out.println("editar");
		Producto producto = productoService.buscarProductoId(id);
		model.addAttribute("producto", producto);
		return "/producto/editarproducto.jsp";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("producto") Producto producto) {
		System.out.println("update");
		productoService.updateProducto(producto);
		return "redirect:/producto";
	}
}
