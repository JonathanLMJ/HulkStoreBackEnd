package com.hulkstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.exception.ResourceNotFoundException;
import com.hulkstore.model.Producto;
import com.hulkstore.service.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> getAllProductos(HttpServletRequest request) throws ResourceNotFoundException{
		return this.productoService.getAllProductos(); 
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto createProducto(@RequestBody Producto producto, HttpServletRequest request) throws ResourceNotFoundException{
		return this.productoService.createProducto(producto); 
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto, HttpServletRequest request) throws ResourceNotFoundException{
		return this.productoService.updateProducto(id, producto); 
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteProducto(@PathVariable Integer id, HttpServletRequest request) throws ResourceNotFoundException{
		System.out.println("entra a delete controller");		
		this.productoService.deleteProducto(id); 
		return "{\"eliminado\":true}";
	}

}
