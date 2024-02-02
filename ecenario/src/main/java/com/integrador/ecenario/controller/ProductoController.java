package com.integrador.ecenario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.ecenario.model.Producto;
import com.integrador.ecenario.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	// Endpoint para obtener todos los productos

	@GetMapping("/Productos")
	public ResponseEntity<List<Producto>> prueba() {
		List<Producto> productos = productoService.getProductos();
		return ResponseEntity.ok(productos);
	}

	// Endpoint para crear un nuevo producto
	@PostMapping("/Producto/crear")
	public ResponseEntity<String> saveProducto(@RequestBody Producto producto) {
		// Verifica si alguno de los campos del producto es nulo
		if (producto.getNombre() == null || producto.getMarca() == null || producto.getCosto() == null
				|| producto.getCantidad_disponible() == null) {
			// Si algún campo es nulo, devuelve una respuesta con código de estado 400
			// (BAD_REQUEST)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos del producto no pueden ser nulos");
		}

		// Guarda el producto utilizando el servicio
		productoService.saveProducto(producto);

		// Devuelve una respuesta con código de estado 201 (CREATED) y un mensaje de
		// éxito
		return ResponseEntity.status(HttpStatus.CREATED).body("El producto fue creado correctamente");
	}

	
	
	// Endpoint para editar un producto existente
	@PutMapping("/Producto/editar/{id_original}")
	public ResponseEntity<?> editarProducto(@PathVariable Long id_original,
			@RequestParam(required = false, name = "nombre") String nuevoNombre,
			@RequestParam(required = false, name = "marca") String nuevaMarca,
			@RequestParam(required = false, name = "costo") Double nuevoCosto,
			@RequestParam(required = false, name = "cantidad") Integer  cantidadDisponible) {
		// Verifica si al menos uno de los campos de edición no es nulo
		if (nuevoNombre == null && nuevaMarca == null && nuevoCosto == null && cantidadDisponible == null) {
			// Si todos los campos de edición son nulos, devuelve una respuesta con código
			// de estado 400 (BAD_REQUEST)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Al menos uno de los campos de edición debe ser no nulo");
		}

		// Edita el producto utilizando el servicio
		productoService.edidProducto(id_original, nuevoNombre, nuevaMarca, nuevoCosto, cantidadDisponible);

		// Obtiene el producto editado
		Producto producto = productoService.findPoducto(id_original);

		// Devuelve una respuesta con código de estado 200 (OK) y el producto editado
		return ResponseEntity.ok(producto);
	}

	// Endpoint para obtener los productos con cantidad menor a 5
	@GetMapping("/Productos/Cant")
	public ResponseEntity<List<Producto>> getProductosCant() {
		// Obtiene la lista de productos con cantidad menor a 5 del servicio
		List<Producto> productos = productoService.getProductosCant();

		// Verifica si la lista de productos es nula o está vacía
		if (productos == null || productos.isEmpty()) {
			// Si la lista está vacía, devuelve una respuesta con código de estado 404
			// (NOT_FOUND)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		// Si hay productos en la lista, devuelve una respuesta con código de estado 200
		// (OK) y la lista de productos
		return ResponseEntity.ok(productos);
	}

	// Endpoint para eliminar un producto
	@DeleteMapping("/Productos/borrar/{id}")
	public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
		// Intenta eliminar el producto utilizando el servicio y guarda el resultado
		boolean deleted = productoService.deleteProducto(id);

		// Verifica si el producto fue eliminado correctamente
		if (deleted) {
			// Si el producto fue eliminado correctamente, devuelve una respuesta con código
			// de estado 200 (OK) y un mensaje de éxito
			return ResponseEntity.ok("Producto eliminado correctamente");
		} else {
			// Si el producto no fue encontrado, devuelve una respuesta con código de estado
			// 404 (NOT_FOUND) y un mensaje de error
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el producto con ID: " + id);
		}
	}

}
