package com.manomanitas.dao;

import java.util.List;
import com.manomanitas.entities.Usuario;

public interface IUsuarioDAO {
  
  List<Usuario> getAllUsuarios();
  Usuario getUsuarioByUser(String user);
  void addUsuario(Usuario usuario);
  void updateUsuario(Usuario usuario);
  void deleteUsuario(String user);
  boolean UsuarioExists(String user, String pass);

}
