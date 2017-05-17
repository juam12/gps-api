package com.manomanitas.dao;

import java.util.List;

import com.manomanitas.entities.Datos;

public interface IDatosDAO {
  
  List<Datos> getGpsByIdGps(Long idGps, Integer limit);

}
