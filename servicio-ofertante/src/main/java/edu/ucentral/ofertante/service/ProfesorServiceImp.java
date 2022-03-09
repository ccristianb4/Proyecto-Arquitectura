package edu.ucentral.ofertante.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ucentral.ofertante.model.Administrador;
import edu.ucentral.ofertante.model.Profesor;
import edu.ucentral.ofertante.repository.AdministradorRepository;
import edu.ucentral.ofertante.repository.ProfesorRepository;



@Service
public class ProfesorServiceImp implements ProfesorService{
	
	@Autowired
	private ProfesorRepository repository;
	@Override
	@Transactional(readOnly = true)
	public Iterable<Profesor> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Profesor> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<Profesor> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Profesor save(Profesor profesor) {
		// TODO Auto-generated method stub
		return repository.save(profesor);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	

}
