package com.integrador.ecenario.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ecenario.model.Producto;
import com.integrador.ecenario.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {
	@Autowired
	IProductoRepository producto;

	// lista de productos
	@Override
	public List<Producto> getProductos() {
		List<Producto> listaPoductos = producto.findAll();// trae la lista de productos de la base de datos y lo guarda
															// en esta lista
		return listaPoductos;
	}

	@Override
	// metodo para buscar el producto mediante el id
	public Producto findPoducto(Long id) {

		return producto.findById(id).orElse(null);
	}

	@Override
	public void saveProducto(Producto producto) {
		this.producto.save(producto);

	}

	@Override
	public void edidProducto(Long idOriginal, String nuevoNombre, String nuevamarca, Double nuevocosto,
			Double cantidadDisponible) {
		// seteamos lo atrubutos que se va resivir en un objeto productos
		Producto producto = this.findPoducto(idOriginal);
		producto.setCantidad_disponible(cantidadDisponible);
		producto.setCosto(nuevocosto);
		producto.setMarca(nuevamarca);
		producto.setNombre(nuevoNombre);
		// guardamos el producto modificado en la base de datos
		this.saveProducto(producto);

	}

	@Override
	public void deleteProducto(Long id) {
		producto.deleteById(id);

	}

	@Override
	public List<Producto> getProductosCant() {
		List<Producto> ProductoCant = new ArrayList<>();
		List <Producto>Productos= this.getProductos();
		for (Producto producto : Productos) {
			if (producto.getCantidad_disponible()<5.0) {
				ProductoCant.add(producto);
			}
			
		}
		

		return ProductoCant;
	}

}
