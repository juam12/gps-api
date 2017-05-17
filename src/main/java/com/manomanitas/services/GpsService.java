package com.manomanitas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manomanitas.dao.IGpsDAO;
import com.manomanitas.entities.Gps;
/**
 * 
 * @author godoy
 *
 */
@Service
public class GpsService implements IGpsService {
  
  @Autowired
  private IGpsDAO gpsDao;

  @Override
  public List<Gps> getAllGps() {
   
    return gpsDao.getAllGps();
  }

  @Override
  public Gps getGpsByIdGps(Long idGps) {
    
    return gpsDao.getGpsByIdGps(idGps);
  }

  @Override
  public boolean addGps(Gps gps) {
    if(gpsDao.gpsExists(gps.getIdGps())){
      return false;
    }else{
      gpsDao.addGps(gps);; 
      return true;
    } 
  }

  @Override
  public void updateGps(Gps gps) {
    gpsDao.updateGps(gps);
    
  }

  @Override
  public void deleteGps(Long idGps) {
    gpsDao.deleteUsuario(idGps);
    
  }

  @Override
  public List<Gps> getGpsByUser(String user) {
    
    return gpsDao.gpsByUser(user);
  }

}
