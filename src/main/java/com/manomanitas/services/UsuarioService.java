package com.manomanitas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manomanitas.dao.IUsuarioDAO;
import com.manomanitas.entities.Usuario;
/**
 * 
 * @author godoy
 *
 */

@Service
public class UsuarioService implements IUsuarioService{
  @Autowired
  private IUsuarioDAO usuarioDAO;
  
  @Override
  public List<Usuario> getAllUsuarios() {
    
    return usuarioDAO.getAllUsuarios();
  }

  @Override
  public Usuario getUsuarioByUser(String user) {
    
    return usuarioDAO.getUsuarioByUser(user);
  }

  @Override
  public synchronized boolean addUsuario(Usuario usuario) {
    if(usuarioDAO.UsuarioExists(usuario.getUser(), usuario.getPass())){
      return false;
    }else{
      usuarioDAO.addUsuario(usuario); 
      return true;
    }   
    
  }

  @Override
  public void updateUsuario(Usuario usuario) {
    usuarioDAO.updateUsuario(usuario);
  }

  @Override
  public void deleteUsuario(String user) {
    usuarioDAO.deleteUsuario(user);
  }

  @Override
  public Boolean getUsuarioByUserAndPass(Usuario usuario) {
    
    return usuarioDAO.UsuarioExists(usuario.getUser(), usuario.getPass());
  }

}
