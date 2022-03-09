package edu.ucentral.planeacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucentral.planeacion.model.PlaneacionCurso;

public interface PlaneacionRepository extends JpaRepository<PlaneacionCurso, Long>{

}
