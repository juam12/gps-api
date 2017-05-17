package com.manomanitas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manomanitas.entities.Datos;

/**
 * 
 * @author godoy
 *
 */
@Transactional
@Repository
public class DatosDAO implements IDatosDAO  {
  
  @PersistenceContext   
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Datos> getGpsByIdGps(Long idGps, Integer limit) {
    String hql = "FROM Datos as dt WHERE dt.idGps = ? ORDER BY dt.fecha DESC , dt.hora DESC";
    return (List<Datos>) entityManager.createQuery(hql).setParameter(1, idGps).setMaxResults(limit).getResultList();
  }

}
