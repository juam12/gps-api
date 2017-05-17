package com.manomanitas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manomanitas.dao.IDatosDAO;
import com.manomanitas.entities.Datos;

/**
 * 
 * @author godoy
 *
 */
@Service
public class DatosService implements IDatosService {
  @Autowired
  private IDatosDAO datosDAO;

  @Override
  public List<Datos> getGpsByIdGps(Long idGps, Integer limit) {
    
    return datosDAO.getGpsByIdGps(idGps, limit);
  }

}
