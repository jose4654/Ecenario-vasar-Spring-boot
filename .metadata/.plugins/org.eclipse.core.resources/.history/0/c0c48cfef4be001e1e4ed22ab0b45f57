package com.integrador.ecenario.service;

import java.util.Date;
import java.util.List;

import com.integrador.ecenario.model.Producto;



public interface IProductoService {
	
	public List<Producto> getProductos();
	//buscamos un Producto con la palabra
	public List<Producto> getProductosCant();
	public Producto findPoducto (Long id);

	// metodo para dar de alta un Producto
	public void saveProducto(Producto producto);
	
	public void deleteProducto(Long id);


//este es un metodo para modificar un curso,primero buscar mediante el id y despues lo modifica 
	public void edidProducto(Long idOriginal, String nuevoNombre, String nuevamarca, Double nuevocosto,Double cantidadDisponible);


}
