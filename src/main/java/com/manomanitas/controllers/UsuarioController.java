package com.manomanitas.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.manomanitas.entities.Usuario;
import com.manomanitas.services.IUsuarioService;
/**
 * 
 * @author godoy
 *
 */
@Controller
@RequestMapping("/datosGps")
public class UsuarioController {
  
  @Autowired
  private IUsuarioService usuarioService;
  
  @RequestMapping(path="usuario/buscar/{user}" , method=RequestMethod.GET)
  public ResponseEntity<?> getUsuarioByUser(@PathVariable("user") String user) {
      Usuario usuario = usuarioService.getUsuarioByUser(user);
      if(usuario == null){ 
        HashMap<String, String> mensaje = new HashMap<String,String>();
        mensaje.put("mensaje", "No se encontro el usuario: " + user);
        return new ResponseEntity<HashMap<String,String>>(mensaje,HttpStatus.CONFLICT);
      }else{
      return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
      }
  }
  
  @RequestMapping(path="usuarios" ,method=RequestMethod.GET)
  public ResponseEntity<?> getAllUsuarios() {
      List<Usuario> list = usuarioService.getAllUsuarios();
     if(list == null){ 
       HashMap<String, String> mensaje = new HashMap<String,String>();
        mensaje.put("mensaje", "usuarios no encontrados");
        return new ResponseEntity<HashMap<String,String>>(mensaje,HttpStatus.CONFLICT);
      }else{     
      return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
      }
  }
  
  @RequestMapping(path="usuario/agregar" ,method=RequestMethod.POST)
  public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario, UriComponentsBuilder builder) {
              boolean flag = usuarioService.addUsuario(usuario);
              if (flag == false) {
                HashMap<String, String> mensaje = new HashMap<String,String>();
                mensaje.put("mensaje", "No se pudo añadir el usuario");
              return new ResponseEntity<HashMap<String,String>>(mensaje , HttpStatus.CONFLICT);
              }
              return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
  }
  
  @RequestMapping(path="usuario/modificar" ,method=RequestMethod.PUT)
  public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, UriComponentsBuilder builder) {
      usuarioService.updateUsuario(usuario);
      return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
  }
  
  @RequestMapping(path="usuario/eliminar/{user}" ,method=RequestMethod.DELETE)
  public ResponseEntity<HashMap<String , String>> deleteUsuario(@PathVariable("user") String user) {
      usuarioService.deleteUsuario(user);
      HashMap<String, String> mensaje = new HashMap<String,String>();
      mensaje.put("mensaje", user + " Eliminado de la base de datos");
      return new ResponseEntity<HashMap<String, String>>(mensaje, HttpStatus.OK);
  }
  
  @RequestMapping(path="usuario/logueo" , method=RequestMethod.POST)
  public ResponseEntity<?> getUsuarioByUser(@RequestBody Usuario usuario) {
    
    HashMap<String, String> mensaje= new HashMap<String,String>();
    if(usuarioService.getUsuarioByUser(usuario.getUser())==null){
      mensaje.put("mensaje", "Usuario incorrecto");
    }
    else{
      Boolean usuExist = usuarioService.getUsuarioByUserAndPass(usuario);
      if(usuExist){ 
        mensaje.put("mensaje", "Usuario existente");
        
      }else{
        mensaje.put("mensaje", "Contraseña incorrecta");
      }
    }
    return new ResponseEntity<HashMap<String,String>>(mensaje,HttpStatus.OK);
 
  }
  

}
