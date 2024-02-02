package com.integrador.ecenario.service;

import java.util.ArrayList;

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
			Integer  cantidadDisponible) {
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
	public boolean deleteProducto(Long id) {
	    // Verifica si existe un producto con el ID especificado en la base de datos
	    if (producto.existsById(id)) {
	        // Si el producto existe, se procede a eliminarlo
	        producto.deleteById(id);
	        // Retorna true para indicar que el producto fue eliminado correctamente
	        return true;  // Producto eliminado correctamente
	    } else {
	        // Si el producto no existe, no se realiza ninguna acción de eliminación
	        // Retorna false para indicar que no se encontró el producto con el ID especificado
	        return false;  // No se encontró el producto con el ID especificado
	    }
	}


//productos que tenga una cantidad meno a 5
	@Override
	public List<Producto> getProductosCant() {
		List<Producto> ProductoCant = new ArrayList<>();
		List <Producto>Productos= this.getProductos();
		for (Producto producto : Productos) {
			if (producto.getCantidad_disponible()<5) {
				ProductoCant.add(producto);
			}
			
		}
		

		return ProductoCant;
	}

	@Override
	public void actualizarCantidadProduc(List<Producto> productos) {
	    boolean cantidadSuficienteParaTodos = true;
  // primero se verifica si hay cantidad de productos para la venta 
	    for (Producto pro : productos) {
	    	Integer  cantidadVendida = 1;
	        Producto cambioPro = findPoducto(pro.getId()); //busca el producto en la base de datos 
	        Integer  cantidadDisponible = cambioPro.getCantidad_disponible();
   // no va >= porque si en igual si se va poder vender 
	        if (cantidadVendida > cantidadDisponible) {
	            cantidadSuficienteParaTodos = false;
	            break; // Salir del ciclo si no hay suficiente cantidad para uno de los productos
	        }
	    }
   // su es true se va poder setear los datos 
	    if (cantidadSuficienteParaTodos) {
	        // Si hay suficiente cantidad disponible para todos los productos, realizar las actualizaciones
	        for (Producto pro : productos) {
	        	Integer  cantidadVendida = 1;
	            Producto cambioPro = findPoducto(pro.getId());
	            Integer  cantidadDisponible = cambioPro.getCantidad_disponible();

	            cantidadDisponible -= cantidadVendida;
	            cambioPro.setCantidad_disponible(cantidadDisponible);
	            saveProducto(cambioPro); //guardamos en la base de datos 
	        }
	    } else {
	        // Si no hay suficiente cantidad disponible para todos los productos, lanzar excepción
	        throw new RuntimeException("La cantidad disponible no es suficiente para la venta");
	    }
	}





}
