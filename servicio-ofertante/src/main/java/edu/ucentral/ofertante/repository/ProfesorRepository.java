package edu.ucentral.ofertante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucentral.ofertante.model.Administrador;
import edu.ucentral.ofertante.model.Profesor;


public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

}
