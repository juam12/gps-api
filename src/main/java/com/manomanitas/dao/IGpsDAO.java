package com.manomanitas.dao;

import java.util.List;

import com.manomanitas.entities.Gps;

public interface IGpsDAO {
  List<Gps> getAllGps();
  Gps getGpsByIdGps(Long idGps);
  void addGps(Gps gps);
  void updateGps(Gps gps);
  void deleteUsuario(Long idGps);
  boolean gpsExists(Long idGps);
  List<Gps> gpsByUser(String user);
}
