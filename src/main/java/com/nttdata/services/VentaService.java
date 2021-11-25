package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Venta;
import com.nttdata.repositories.VentaRepository;

@Service
public class VentaService {

	@Autowired
	VentaRepository ventaRepository;

	public List<Venta> obtenerListaVentas() {
		return ventaRepository.findAll();
	}

	public void insertarVenta(@Valid Venta venta) {
		ventaRepository.save(venta);	
	}

	public Venta buscarVentaId(Long id) {
		return ventaRepository.findById(id).get();
	}

	public void eliminarVentaObjeto(Venta venta) {
		ventaRepository.delete(venta);
		
	}

	
}
