package edu.ucentral.planeacion.service;

import org.springframework.stereotype.Service;

import edu.ucentral.commons.service.service.CommonServiceImp;
import edu.ucentral.planeacion.model.PlaneacionCurso;
import edu.ucentral.planeacion.repository.PlaneacionRepository;

@Service
public class PlaneacionServiceImple extends CommonServiceImp<PlaneacionCurso, PlaneacionRepository> implements PlaneacionService{

}
