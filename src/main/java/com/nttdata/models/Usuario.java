package com.nttdata.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String edad;
	private String rut;
	private String email;
	private String password;
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
	
	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}



	public Usuario() {
		super();
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEdad() {
		return edad;
	}



	public void setEdad(String edad) {
		this.edad = edad;
	}



	public String getRut() {
		return rut;
	}



	public void setRut(String rut) {
		this.rut = rut;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", rut=" + rut + ", email="
				+ email + ", password=" + password + "]";
	}



	public Usuario(String nombre, String apellido, String edad, String rut, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.rut = rut;
		this.email = email;
		this.password = password;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
}
