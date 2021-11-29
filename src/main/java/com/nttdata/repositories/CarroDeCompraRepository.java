package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.CarroDeCompra;

@Repository
public interface CarroDeCompraRepository extends JpaRepository<CarroDeCompra, Long>{

}
