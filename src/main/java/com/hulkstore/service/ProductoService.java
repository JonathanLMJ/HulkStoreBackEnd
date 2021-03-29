package com.hulkstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hulkstore.exception.ResourceNotFoundException;
import com.hulkstore.model.Producto;

@Service
public class ProductoService{
	
	List<Producto> listaProductos = new ArrayList<Producto>();
		
	public List<Producto> getAllProductos() throws ResourceNotFoundException{
				
		if (listaProductos.isEmpty()) {
			throw new ResourceNotFoundException("No existen productos creados"); 
		} else {
			System.out.println("entra al else");
			return listaProductos;
		} 
	}
	
	public Producto createProducto(Producto nuevoProducto) throws ResourceNotFoundException{
		if (nuevoProducto.getNombreProducto().isBlank()) {
			System.out.println("entra a nombre vacío");
			throw new ResourceNotFoundException("El nombre no puede estar vacío");
		} else {
			listaProductos.add(nuevoProducto);
			return nuevoProducto;
		}
				
		
	}
	
	public Producto updateProducto(Integer id, Producto productoModificado) throws ResourceNotFoundException{		
		if(positionById(id) != -1) {
			productoModificado.setIdProducto(id);
			listaProductos.set(positionById(id), productoModificado);
			return productoModificado;
		} else {
			throw new ResourceNotFoundException("El ID no existe");
		}
		
				
		
	}
	
	public void deleteProducto(Integer id) throws ResourceNotFoundException{	
		System.out.println("entra a delete");
		
		if(positionById(id) != -1) {
			listaProductos.remove(positionById(id).intValue());
		} else {
			throw new ResourceNotFoundException("El ID no existe");
		}
		
	}
	
	public Integer positionById(Integer id) {
			
		for(int i=0; i <= listaProductos.size()-1; i++) {
			
			if(listaProductos.get(i).getIdProducto() == id) {
				System.out.println("id:" + id + " encontrado en la posición: " + i);
				return i;
			}
		}
		System.out.println("id NO encontrado");
		
		return -1;
		
	}

}
