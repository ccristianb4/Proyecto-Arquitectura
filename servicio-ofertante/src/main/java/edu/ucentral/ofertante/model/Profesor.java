package edu.ucentral.ofertante.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "campo vacio error")
	@Size(min = 1,max = 15,message = "la identificacion es erronea")
	private String cedula;
	@NotEmpty(message = "el nombre no debe estar vacio")
	@Size(min = 5,max = 50,message = "el nombre debe contener entre 5-50 caracteres")
	private String nombre;
	@NotEmpty(message = "el usuario no debe estar vacio")
	@Size(min = 5,max = 15,message = "el usuario debe contener entre 5-15 caracteres")
	private String usuario;
	@NotEmpty(message = "el nombre no debe estar vacio")
	@Size(min = 5,max = 15,message = "la contraseña debe contener entre 5-15 caracteres")
	private String contra;
	private String rol = "Profesor";
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContra() {
		return contra;
	}


	public void setContra(String contra) {
		this.contra = contra;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
