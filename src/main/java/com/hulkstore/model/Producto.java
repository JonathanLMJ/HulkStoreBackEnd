package com.hulkstore.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Producto {
	
	private Integer  		idProducto;
	private String 			nombreProducto;
	private String			descripcionProducto;
	private BigDecimal 		valorProducto;
	private Integer 		tipoProducto;
	
	private static int		autoIncrement = 1;
	
	public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, BigDecimal valorProducto, Integer tipoProducto) {
		setIdProducto(autoIncrement++);
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.valorProducto = valorProducto;
		this.tipoProducto = tipoProducto;
	}

}
