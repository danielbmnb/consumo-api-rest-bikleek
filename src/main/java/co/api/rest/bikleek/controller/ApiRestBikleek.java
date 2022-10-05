package co.api.rest.bikleek.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import co.api.rest.bikleek.dto.ProductoDTO;

@RestController
@RequestMapping("consumoApi")
public class ApiRestBikleek {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/listaProducto")
	public String obtenerListaProductos() {

		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange(
	    		  "http://localhost:8070/productos/listarProductos", HttpMethod.GET, entity, String.class).getBody();
	   }
	
	@RequestMapping("/detalleProductos/{id}")
	public String detalleProductos(@PathVariable Long id) {

		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange(
	    		  "http://localhost:8070/productos/detalleProducto/"+id, HttpMethod.GET, entity, String.class).getBody();
	   }

	@RequestMapping("/guardarProducto")
	public String guardarProductos(@RequestBody ProductoDTO productoDTO) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<ProductoDTO> entity = new HttpEntity<ProductoDTO>(productoDTO, headers);

		return restTemplate
				.exchange("http://localhost:8070/productos/guardarProducto", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	@RequestMapping("/editarProducto/{id}")
	public String actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<ProductoDTO> entity = new HttpEntity<ProductoDTO>(productoDTO,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8070/productos/editarProducto/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	
	@RequestMapping("/cambiarEstadoProducto/{id}")
	public String cambiarEstadoProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<ProductoDTO> entity = new HttpEntity<ProductoDTO>(productoDTO,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8070/productos/cambiarEstadoProducto/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	
	@RequestMapping(value = "/eliminarProducto/{id}")
	   public String eliminarProducto(@PathVariable Long id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8070/productos/eliminarProducto/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
	
}
