package com.manomanitas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manomanitas.entities.Usuario;

/**
 * 
 * @author godoy
 *
 */
@Transactional
@Repository
public class UsuarioDAO implements IUsuarioDAO{
  @PersistenceContext   
  private EntityManager entityManager;    
 
  
  @Override
  public Usuario getUsuarioByUser(String user) {
    
    return entityManager.find(Usuario.class, user );
  }
  @Override
  public void addUsuario(Usuario usuario) {
    entityManager.persist(usuario);
    
  }
  @Override
  public void updateUsuario(Usuario usuario) {
    Usuario usu = getUsuarioByUser(usuario.getUser());
    usu.setEmail(usuario.getEmail());
    usu.setNombre(usuario.getNombre());
    usu.setPass(usuario.getPass());
    entityManager.flush();
    
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Usuario> getAllUsuarios() {
    String hql = "FROM Usuario";
    return (List<Usuario>) entityManager.createQuery(hql).getResultList();
  }
  
  @Override
  public void deleteUsuario(String user) {
    entityManager.remove(getUsuarioByUser(user));
    
  }
  
  @Override
  public boolean UsuarioExists(String user, String pass) {
    String hql = "FROM Usuario as usu WHERE usu.user = ? and usu.pass = ?";
    int count = entityManager.createQuery(hql).setParameter(1, user)
                  .setParameter(2, pass).getResultList().size();
    return count > 0 ? true : false;
  }
  

}
