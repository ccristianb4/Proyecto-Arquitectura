package edu.ucentral.planeacion.controller;

import javax.validation.Valid;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.planeacion.model.PlaneacionCurso;
import edu.ucentral.planeacion.service.PlaneacionService;

@RestController
public class PlaneacionController extends CommonController<PlaneacionCurso, PlaneacionService>{
	@PutMapping("modificar/{id}")
	public ResponseEntity<?> modificar(@Valid @RequestBody PlaneacionCurso planeacion,BindingResult result,@PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<PlaneacionCurso> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		PlaneacionCurso planeacionDB = optional.get();
		planeacionDB.setIdentificacion(planeacion.getIdentificacion());
		planeacionDB.setNombre_profesor(planeacion.getNombre_profesor());
		planeacionDB.setLugar(planeacion.getLugar());
		planeacionDB.setFecha(planeacion.getFecha());
		planeacionDB.setFranja(planeacion.getFranja());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(planeacionDB));
	}
}
