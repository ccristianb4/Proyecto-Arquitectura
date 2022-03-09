package edu.ucentral.ofertante.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.ucentral.ofertante.model.Administrador;



public interface AdministradorService{
	public Iterable<Administrador> findAll();
	public Page<Administrador> findAll(Pageable pageable);
	public Optional<Administrador> findById(Long id);
	public Administrador save(Administrador administrador);
	public void deleteById(Long id);
}
