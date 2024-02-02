package com.integrador.ecenario.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private LocalDate fecha;
	private Double total;
	
	 @ManyToMany
	    @JoinTable(
	        name = "venta_producto",
	        joinColumns = @JoinColumn(name = "venta_id"),
	        inverseJoinColumns = @JoinColumn(name = "producto_id")
	    )
	private List<Producto> listaProductos;
	@OneToOne
	//composicion
	private Cliente uncliente;
	
	

}
