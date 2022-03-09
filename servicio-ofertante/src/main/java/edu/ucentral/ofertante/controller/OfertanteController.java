package edu.ucentral.ofertante.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import edu.ucentral.ofertante.model.Administrador;
import edu.ucentral.ofertante.model.Profesor;
import edu.ucentral.ofertante.service.AdministradorService;
import edu.ucentral.ofertante.service.ProfesorService;



@RestController
public class OfertanteController{
	@Autowired
	private AdministradorService service;
	@Autowired
	private ProfesorService serviceProfesor;
	
	@GetMapping("/ofertante")
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("ofertante/pagina")
	public ResponseEntity<?> listar(Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
	
	@GetMapping("ofertante/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<Administrador> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping("ofertante/crear")
	public ResponseEntity<?> crear(@Valid @RequestBody Administrador administrador, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(administrador));
	}
	
	
	
	@DeleteMapping("ofertante/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("ofertante/modificar/{id}")
	public ResponseEntity<?> modificar(@Valid @RequestBody Administrador administrador,BindingResult result,@PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Administrador> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Administrador adminisDB = optional.get();
		adminisDB.setCedula(administrador.getCedula());
		adminisDB.setNombre(administrador.getNombre());
		adminisDB.setUsuario(administrador.getUsuario());
		adminisDB.setContra(administrador.getContra());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(adminisDB));
	}
	
	@GetMapping("/profesor")
	public ResponseEntity<?> listarP(){
		return ResponseEntity.ok().body(serviceProfesor.findAll());
	}
	
	@GetMapping("profesor/pagina")
	public ResponseEntity<?> listarP(Pageable pageable){
		return ResponseEntity.ok().body(serviceProfesor.findAll(pageable));
	}
	
	@GetMapping("profesor/buscar/{id}")
	public ResponseEntity<?> buscarPorIdP(@PathVariable Long id){
		Optional<Profesor> optional = serviceProfesor.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping("profesor/crear")
	public ResponseEntity<?> crearP(@Valid @RequestBody Profesor profesor, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceProfesor.save(profesor));
	}
	
	
	
	@DeleteMapping("profesor/eliminar/{id}")
	public ResponseEntity<?> eliminarP(@PathVariable Long id){
		serviceProfesor.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("profesor/modificar/{id}")
	public ResponseEntity<?> modificarP(@Valid @RequestBody Profesor profesor,BindingResult result,@PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Profesor> optional = serviceProfesor.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Profesor profesorDB = optional.get();
		profesorDB.setCedula(profesor.getCedula());
		profesorDB.setNombre(profesor.getNombre());
		profesorDB.setUsuario(profesor.getUsuario());
		profesorDB.setContra(profesor.getContra());
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceProfesor.save(profesorDB));
	}
	
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String,Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err ->{
			errores.put(err.getField(), "El atributo "+ err.getField()+" "+err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
	
}
