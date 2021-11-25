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

import com.nttdata.models.Venta;
import com.nttdata.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	VentaService ventaService;
	
	@RequestMapping("")
	public String venta(@ModelAttribute("venta") Venta venta, Model model) {
		model.addAttribute("listaVentas", ventaService.obtenerListaVentas());
		return "venta.jsp";
	}
	
	@RequestMapping("/generarventa")
	public String generarventa (@Valid @ModelAttribute("venta") Venta venta)
	{
		System.out.println(venta.getId() + " " + venta.getPrecio() );
		ventaService.insertarVenta(venta);//IMPORTANTE!
		return "redirect:/venta";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarVenta(@RequestParam("id") Long id) {
		Venta venta = ventaService.buscarVentaId(id);
		
		if(venta !=null) {
			ventaService.eliminarVentaObjeto(venta);
		}
		return "redirect:/venta";
	}
	
	@RequestMapping("/{id}/editar")
	public String edit(@PathVariable("id") Long id, Model model) {
		
		System.out.println("editar");
		Venta venta = ventaService.buscarVentaId(id);
		model.addAttribute("venta", venta);
		return "editarventa.jsp";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("venta") Venta venta) {
		
		System.out.println("update");
		ventaService.updateVenta(venta);
		return "redirect:/venta";
	}
	
}
