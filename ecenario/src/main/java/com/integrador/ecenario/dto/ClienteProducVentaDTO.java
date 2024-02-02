package com.integrador.ecenario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
 @Setter
public class ClienteProducVentaDTO {
	private Long id_venta;
    private Double tota_venta;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;
	public ClienteProducVentaDTO() {
		super();
	}
	public ClienteProducVentaDTO(Long id_venta, Double tota_venta, int cantidad_productos, String nombre_cliente,
			String apellido_cliente) {
		super();
		this.id_venta = id_venta;
		this.tota_venta = tota_venta;
		this.cantidad_productos = cantidad_productos;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
	}
    

}
