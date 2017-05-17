package com.manomanitas.services;

import java.util.List;

import com.manomanitas.entities.Gps;

public interface IGpsService {
  List<Gps> getAllGps();
  Gps getGpsByIdGps(Long  idGps);
  boolean addGps(Gps gps);
  void updateGps(Gps gps);
  void deleteGps(Long  idGps);
  List<Gps> getGpsByUser(String user);
}
