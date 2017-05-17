package com.manomanitas.clientes;

import org.springframework.http.HttpHeaders;
import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.manomanitas.entities.Usuario;


public class RestClienteUtil {
 public void addUsuarioCliente(){
   HttpHeaders headers = new HttpHeaders();
   headers.setContentType(MediaType.APPLICATION_JSON);
   RestTemplate restTemplate = new RestTemplate();
   String url =  "http://gpslocationfinder.com:10000/datosGps/usuario";
   Usuario usuario = new Usuario();
   usuario.setEmail("juam132@hotmail.com");
   usuario.setNombre("juam13");
   usuario.setPass("12345");
   usuario.setUser("jaum13");
   HttpEntity<Usuario> requestEntity = new HttpEntity<Usuario>(usuario, headers);
   URI uri = restTemplate.postForLocation(url, requestEntity);
   System.out.println(uri.getPath());
   
 }
 
 public static void main(String args[]) {
   RestClienteUtil util = new RestClienteUtil();
   util.addUsuarioCliente();
} 
}
