package com.integrador.ecenario.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Venta {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private LocalDate fecha;
	private Double total;
	@OneToMany
	private List<Producto> listaProductos;
	@OneToOne
	private Cliente uncliente;
	public Venta() {
		super();
	}
	public Venta(Long id, LocalDate fecha, Double total, List<Producto> listaProductos, Cliente uncliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.listaProductos = listaProductos;
		this.uncliente = uncliente;
	}
	

}
