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

import com.manomanitas.entities.Gps;
import com.manomanitas.services.IGpsService;

/**
 * 
 * @author godoy
 *
 */
@Controller
@RequestMapping("/datosGps")
public class GpsController {
  
  @Autowired
  private IGpsService gpsService;
  
  @RequestMapping(path="gps/buscar/{idGps}" , method=RequestMethod.GET)
  public ResponseEntity<?> getgpsByIdGps(@PathVariable("idGps") Long idGps) {
      Gps gps = gpsService.getGpsByIdGps(idGps);
      if(gps == null){ 
        HashMap<String, String> mensaje = new HashMap<String,String>();
        mensaje.put("mensaje", "No se encontro el gps: " + idGps);
        return new ResponseEntity<HashMap<String,String>>(mensaje,HttpStatus.CONFLICT);
      }else{
        return new ResponseEntity<Gps>(gps, HttpStatus.OK);
      }
  }
  
  @RequestMapping(path="gps/todos" ,method=RequestMethod.GET)
  public ResponseEntity<?> getAllGps() {
      List<Gps> list = gpsService.getAllGps();
      if(list == null){ 
        HashMap<String, String> mensaje = new HashMap<String,String>();
         mensaje.put("mensaje", "la busqueda de todos los gps fallo");
         return new ResponseEntity<HashMap<String,String>>(mensaje,HttpStatus.CONFLICT);
       }else{ 
         return new ResponseEntity<List<Gps>>(list, HttpStatus.OK);
       }
  }
  
  @RequestMapping(path="gps/agregar" ,method=RequestMethod.POST)
  public ResponseEntity<?> addgps(@RequestBody Gps gps, UriComponentsBuilder builder) {
      boolean flag = gpsService.addGps(gps);
      if (flag == false) {  
        HashMap<String, String> mensaje = new HashMap<String,String>();
        mensaje.put("mensaje", "No se pudo añadir el gps");
        return new ResponseEntity<HashMap<String,String>>(mensaje , HttpStatus.CONFLICT);
      }
        return new ResponseEntity<Gps>(gps, HttpStatus.CREATED);
  }
  
  @RequestMapping(path="gps/modificar" ,method=RequestMethod.PUT)
  public ResponseEntity<Gps> updategps(@RequestBody Gps gps, UriComponentsBuilder builder) {
      gpsService.updateGps(gps);
      return new ResponseEntity<Gps>(gps, HttpStatus.OK);
  }
  
  @RequestMapping(path="gps/eliminar/{idGps}" ,method=RequestMethod.DELETE)
  public ResponseEntity<HashMap<String , String>> deletegps(@PathVariable("idGps") Long idGps) {
      gpsService.deleteGps(idGps);
      HashMap<String, String> mensaje = new HashMap<String,String>();
      mensaje.put("mensaje", idGps + " Eliminado de la base de datos");
      return new ResponseEntity<HashMap<String, String>>(mensaje, HttpStatus.OK);
  }   
  
  @RequestMapping(path="gps/buscar/usuario/{user}" , method=RequestMethod.GET)
  public ResponseEntity<?> getGpsByUser(@PathVariable("user") String user) {
    List<Gps> list = gpsService.getGpsByUser(user);
    if(list == null){ 
      HashMap<String, String> mensaje = new HashMap<String,String>();
       mensaje.put("mensaje", "Fallo la busqueda de gps para el usuario: " + user);
       return new ResponseEntity<HashMap<String,String>>(mensaje,HttpStatus.CONFLICT);
     }else{ 
       return new ResponseEntity<List<Gps>>(list, HttpStatus.OK);
     }
  }
  

}
