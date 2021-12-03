package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	
	List<Usuario> findAll();

	
	@Query(value= "SELECT * FROM usuarios Where nombre = ?1", nativeQuery = true)
	List<Usuario> obtenerUsuarioWhereIdSQL(String nombre);



}
