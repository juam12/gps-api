package com.manomanitas.services;

import java.util.List;

import com.manomanitas.entities.Usuario;
public interface IUsuarioService {
  List<Usuario> getAllUsuarios();
  Usuario getUsuarioByUser(String user);
  boolean addUsuario(Usuario usuario);
  void updateUsuario(Usuario usuario);
  void deleteUsuario(String user);
  Boolean getUsuarioByUserAndPass(Usuario usuario);

}
