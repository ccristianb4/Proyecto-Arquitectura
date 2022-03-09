package edu.ucentral.planeacion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.io.*;
import java.sql.Date;

@Entity(name = "planeaciones")
public class PlaneacionCurso implements Serializable{
	
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "la ident no debe estar vacio")
	private String identificacion;
	@NotEmpty(message = "el nombre no debe estar vacio")
	@Size(min = 5,max = 50,message = "el nombre debe contener entre 5-50 caracteres")
	private String nombre_profesor;
	@NotEmpty(message = "el lugar no debe estar vacio")
	@Size(min = 5,max = 50,message = "el lugar debe contener entre 5-50 caracteres")
	private String lugar;
	@NotEmpty(message = "la fecha no debe estar vacio")
	private Date fecha;
	
	@NotEmpty(message = "la franja horario no debe estar vacio")
	private String franja;
	
	
	
	
	public String getLugar() {
		return lugar;
	}




	public void setLugar(String lugar) {
		this.lugar = lugar;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getIdentificacion() {
		return identificacion;
	}




	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}




	public String getNombre_profesor() {
		return nombre_profesor;
	}




	public void setNombre_profesor(String nombre_profesor) {
		this.nombre_profesor = nombre_profesor;
	}




	public Date getFecha() {
		return fecha;
	}




	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	public String getFranja() {
		return franja;
	}




	public void setFranja(String franja) {
		this.franja = franja;
	}




	private static final long serialVersionUID = 1L;
}
