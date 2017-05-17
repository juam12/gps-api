package com.manomanitas.services;

import java.util.List;

import com.manomanitas.entities.Datos;

public interface IDatosService {

  List<Datos> getGpsByIdGps(Long idGps, Integer limit);
}
