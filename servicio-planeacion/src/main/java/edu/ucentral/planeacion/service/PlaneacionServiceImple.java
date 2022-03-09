package edu.ucentral.planeacion.service;

import org.springframework.stereotype.Service;

import edu.ucentral.commons.service.service.CommonServiceImp;
import edu.ucentral.planeacion.model.Administrador;
import edu.ucentral.planeacion.repository.PlaneacionRepository;

@Service
public class PlaneacionServiceImple extends CommonServiceImp<Administrador, PlaneacionRepository> implements PlaneacionService{

}
