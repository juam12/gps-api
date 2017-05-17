package com.manomanitas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
*
* @author godoy
*/
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id
  private String user;
  
  private String nombre;
  private String pass;
  private String email;
  
  public Usuario(String user, String nombre, String pass, String email) {
    super();
    this.user = user;
    this.nombre = nombre;
    this.pass = pass;
    this.email = email;
  }
  
  public Usuario() {
    super();
  }
  
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getPass() {
    return pass;
  }
  public void setPass(String pass) {
    this.pass = pass;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
 
}
