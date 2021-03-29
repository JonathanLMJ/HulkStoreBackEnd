package com.hulkstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.exception.ResourceNotFoundException;
import com.hulkstore.model.TipoProducto;
import com.hulkstore.service.TipoProductoService;

@RestController
@RequestMapping("/tipoProducto")
@CrossOrigin(origins = "*")
public class TipoProductoController {

	@Autowired
	private TipoProductoService tipoProductoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TipoProducto> getAllProductos(HttpServletRequest request) throws ResourceNotFoundException{
		return this.tipoProductoService.getAllTiposProducto(); 
	}
}
