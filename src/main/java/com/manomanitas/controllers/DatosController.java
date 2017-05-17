package com.manomanitas.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manomanitas.entities.Datos;
import com.manomanitas.services.IDatosService;

/**
 * 
 * @author godoy
 *
 */
@Controller
@RequestMapping("/datosGps")
public class DatosController {
  
  @Autowired
  private IDatosService datosService;
  
  @RequestMapping(path="datos/{idGps}/{limit}" ,method=RequestMethod.GET)
  public ResponseEntity<?> getAllGps(@PathVariable("idGps") Long idGps, @PathVariable("limit") Integer limit) {
      List<Datos> list = datosService.getGpsByIdGps(idGps, limit);
      if(list == null){ 
        HashMap<String, String> mensaje = new HashMap<String,String>();
         mensaje.put("mensaje", "fallo la busqueda de datos");
         return new ResponseEntity<HashMap<String,String>>(mensaje,HttpStatus.CONFLICT);
       }else{ 
         return new ResponseEntity<List<Datos>>(list, HttpStatus.OK);
       }
  }

}
