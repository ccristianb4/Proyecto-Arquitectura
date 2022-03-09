package edu.ucentral.ofertante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.ucentral.ofertante.model.Profesor;



public interface ProfesorService {
	public Iterable<Profesor> findAll();
	public Page<Profesor> findAll(Pageable pageable);
	public Optional<Profesor> findById(Long id);
	public Profesor save(Profesor profesor);
	public void deleteById(Long id);
}
