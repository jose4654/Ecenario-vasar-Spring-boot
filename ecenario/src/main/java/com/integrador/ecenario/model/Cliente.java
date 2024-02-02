package com.integrador.ecenario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
	
	
}