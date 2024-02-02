package com.integrador.ecenario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Producto {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String nombre;
	private String marca;
	private Double costo;
	private Double cantidad_disponible;
	
	public Producto(Long id, String nombre, String marca, Double costo, Double cantidad_disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.costo = costo;
		this.cantidad_disponible = cantidad_disponible;
	}

	public Producto() {
		super();
	}
	

}
