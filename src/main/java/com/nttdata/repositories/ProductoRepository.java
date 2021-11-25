package com.nttdata.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

	
}
