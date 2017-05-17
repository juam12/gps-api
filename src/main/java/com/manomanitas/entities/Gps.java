package com.manomanitas.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author godoy
 */
@Entity
@Table(name="gps")
public class Gps implements Serializable{
  private static final long serialVersionUID = 1L;
 
 @Id
 @Column(name = "idgps")
 private Long idGps;
 
 @Column(name = "nombregps")
 private String nombreGps;
 
 @Column(name = "tipo")
 private Integer tipo;
 
 @Column(name = "user")
 private String user;
 
public Gps(Long idGps, String nombreGps, Integer tipo, String user) {
  super();
  this.idGps = idGps;
  this.nombreGps = nombreGps;
  this.tipo = tipo;
  this.user = user;
}

public Gps() {
  super();
}

public Long getIdGps() {
  return idGps;
}

public void setIdGps(Long idGps) {
  this.idGps = idGps;
}

public String getNombreGps() {
  return nombreGps;
}

public void setNombreGps(String nombreGps) {
  this.nombreGps = nombreGps;
}

public Integer getTipo() {
  return tipo;
}

public void setTipo(Integer tipo) {
  this.tipo = tipo;
}

public String getUser() {
  return user;
}

public void setUser(String user) {
  this.user = user;
}


 
 
 

}
