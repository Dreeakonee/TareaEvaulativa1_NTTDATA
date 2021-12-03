package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//buscar poremail
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	//insertar usuario con psw hasheada
	//////////////////////////AKIIIIIIIIIIIIIIIIIIIIIIIIII 1:15:23
	public Usuario registroUsuario(Usuario usuario) {
		Usuario usuario2 = findByEmail(usuario.getEmail());
		String password_hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(password_hashed);
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> obtenerListaUsuarios() {
		return usuarioRepository.findAll();
	}

	public void insertarUsuario(@Valid Usuario usuario){
		usuarioRepository.save(usuario);	
	}

	public Usuario buscarUsuarioId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuarioObjeto(Usuario usuario) {
		usuarioRepository.delete(usuario);
		
	}

	public void updateUsuario(@Valid Usuario usuario) {
		if(usuarioRepository.existsById(usuario.getId())) {
			usuarioRepository.save(usuario);
		}
		
	}
	
	public List<Usuario> obtenerUsuarioWhereIdSQL(String nombre){
		return usuarioRepository.obtenerUsuarioWhereIdSQL(nombre);
	}
	
	public Boolean loginUsuario(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario==null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
		
	}
	

}
