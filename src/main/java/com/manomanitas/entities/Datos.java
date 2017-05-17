package com.manomanitas.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author godoy
 */
@Entity
public class Datos implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "iddatos")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer idDatos;
 
 @Column(name = "idgps")
 private Long idGps;
 
 private String latitud;
 
 private String longitud;
 
 private Date fecha;
 
 private String velocidad;
 
 private Time hora;
 
public Datos(Integer idDatos, Long idGps, String latitud, String longitud, Date fecha, String velocidad, Time hora) {
  super();
  this.idDatos = idDatos;
  this.idGps = idGps;
  this.latitud = latitud;
  this.longitud = longitud;
  this.fecha = fecha;
  this.velocidad = velocidad;
  this.hora = hora;
}

public Datos() {
  super();
}

public Integer getIdDatos() {
  return idDatos;
}
public void setIdDatos(Integer idDatos) {
  this.idDatos = idDatos;
}
public Long getIdGps() {
  return idGps;
}
public void setIdGps(Long idGps) {
  this.idGps = idGps;
}
public String getLatitud() {
  return latitud;
}
public void setLatitud(String latitud) {
  this.latitud = latitud;
}
public String getLongitud() {
  return longitud;
}
public void setLongitud(String longitud) {
  this.longitud = longitud;
}
public Date getFecha() {
  return fecha;
}
public void setFecha(Date fecha) {
  this.fecha = fecha;
}
public String getVelocidad() {
  return velocidad;
}
public void setVelocidad(String velocidad) {
  this.velocidad = velocidad;
}
public Time getHora(){
  return hora;
}

public void setHora(Time hora){
  this.hora = hora;
}
 
    
}
