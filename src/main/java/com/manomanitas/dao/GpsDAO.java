package com.manomanitas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manomanitas.entities.Gps;

/**
 * 
 * @author godoy
 *
 */
@Transactional
@Repository
public class GpsDAO implements IGpsDAO {
  
  @PersistenceContext   
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Gps> getAllGps() {
    String hql = "FROM Gps";
    return (List<Gps>) entityManager.createQuery(hql).getResultList();
   
  }

  @Override
  public Gps getGpsByIdGps(Long idGps) {
    
    return entityManager.find(Gps.class, idGps);
  }

  @Override
  public void updateGps(Gps gps) {
    Gps gpsUpdate = getGpsByIdGps(gps.getIdGps());
    gpsUpdate.setNombreGps(gps.getNombreGps());
    gpsUpdate.setTipo(gps.getTipo());
    gpsUpdate.setUser(gps.getUser());
    entityManager.flush();
    
  }

  @Override
  public void addGps(Gps gps) {
    entityManager.persist(gps);    
  }

  @Override
  public void deleteUsuario(Long idGps) {
    entityManager.remove(getGpsByIdGps(idGps));
    
  }

  @Override
  public boolean gpsExists(Long idGps) {
    String hql = "FROM Gps as gps WHERE gps.idGps = ? ";
    int count = entityManager.createQuery(hql).setParameter(1, idGps)
                  .getResultList().size();
    return count > 0 ? true : false;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Gps> gpsByUser(String user) {
    String hql = "FROM Gps as gps WHERE gps.user = ? ";
    return (List<Gps>) entityManager.createQuery(hql).setParameter(1, user).getResultList();
  }

}
