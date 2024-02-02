package com.integrador.ecenario.service;

import java.time.LocalDate;
import java.util.List;

import com.integrador.ecenario.dto.ClienteProducVentaDTO;
import com.integrador.ecenario.model.Cliente;
import com.integrador.ecenario.model.Producto;
import com.integrador.ecenario.model.Venta;

public interface IVentaService {
	public List<Venta> getVentas();
	//buscamos un Producto con la palabra

	public Venta findVenta (Long id);
	public List<Producto> findVentaProductos (Long id);

	// metodo para dar de alta un Producto
	public void saveVenta(Venta venta);
	
	public void deleteventa(Long id);
	public ClienteProducVentaDTO ventaMontoAlto();


//este es un metodo para modificar un curso,primero buscar mediante el id y despues lo modifica 
	public void edidVenta(Long idOriginal, LocalDate fecha, Double total, List<Producto> listaProductos,Cliente uncliente);


}
