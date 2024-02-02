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
public class Cliente {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
	public Cliente() {
		super();
	}
	public Cliente(Long id, String nombre, String apellido, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

}
