package com.integrador.ecenario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	    private IProductoService productServ;
	 
	 @PostMapping ("/Producto/crear")
	    public String saveProducto (@RequestBody Producto producto) {
		 productServ.saveProducto(producto);
	        
	        return "La persona fue creada correctamente";
	    }
	    @GetMapping ("/Productos")
	    public List<Producto> getPoductos() {
	        
	        return productServ.getProductos();
	    }
	    @GetMapping ("/Productos/Cant")
	    public List<Producto> getPoductosCant() {
	        
	        return productServ.getProductosCant();
	    }
	    
	    
	    
	    @DeleteMapping ("/Productos/borrar/{id}")
	    public String deletePersona(@PathVariable Long id) {
	    	productServ.deleteProducto(id);
	        return "producto eliminado correctamente";
	    }
	    
	    @PutMapping ("/personas/editar/{id_original}")
	    public Producto edidProducto (@PathVariable Long id_original,
	            @RequestParam(required = false, name = "nombre") String nuevoNombre,
	            @RequestParam(required = false, name = "marca") String nuevamarca,
	            @RequestParam(required = false, name = "costo") Double nuevocosto,
	            @RequestParam(required = false, name = "cantidad") Double cantidadDisponible) {
	            //midiicamos el producto
	    	productServ.edidProducto(id_original, nuevoNombre, nuevamarca, nuevocosto, cantidadDisponible);
	        //buscamos el producto modificado 
	        Producto produ = productServ.findPoducto(id_original);
	        //se lo enviamos a usuario
	        return produ;

	    }
	    
	   

}
