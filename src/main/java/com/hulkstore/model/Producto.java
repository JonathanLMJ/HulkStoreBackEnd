package com.hulkstore.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter 
public class Producto {
	
	private Integer  idProducto;
	private String 		nombreProducto;
	private String		descripcionProducto;
	private BigDecimal 	valorProducto;
	
	private static int		autoIncrement = 1;
	
	public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, BigDecimal valorProducto) {
		setIdProducto(autoIncrement++);
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.valorProducto = valorProducto;
	}

}
