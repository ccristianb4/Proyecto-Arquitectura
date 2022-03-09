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
import edu.ucentral.ofertante.repository.AdministradorRepository;



@Service
public class AdministradorServiceImp implements AdministradorService{
	
	@Autowired
	private AdministradorRepository repository;
	@Override
	@Transactional(readOnly = true)
	public Iterable<Administrador> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Administrador> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<Administrador> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Administrador save(Administrador administrador) {
		// TODO Auto-generated method stub
		return repository.save(administrador);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	

}
