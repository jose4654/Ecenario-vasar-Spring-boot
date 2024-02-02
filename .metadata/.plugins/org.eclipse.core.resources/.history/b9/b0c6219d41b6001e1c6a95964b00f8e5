package com.integrador.ecenario.controller;

import java.time.LocalDate;
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

import com.integrador.ecenario.dto.ClienteProducVentaDTO;
import com.integrador.ecenario.model.Cliente;
import com.integrador.ecenario.model.Producto;
import com.integrador.ecenario.model.Venta;
import com.integrador.ecenario.service.IVentaService;

@RestController
public class VentaController {
	@Autowired
	IVentaService venta;

	 @PostMapping ("/Venta/crear")
	    public String saveVenta (@RequestBody Venta venta) {
		 this.venta.saveVenta(venta);  
	        return "La venta fue creada correctamente";
	    } 
	    @GetMapping ("/Ventas")
	    public List<Venta> getVentas() {     
	        return venta.getVentas();
	    }  
	    @GetMapping ("/Ventas/alto")
	    public ClienteProducVentaDTO getVentasalto() {     
	        return venta.ventaMontoAlto();
	    }  
	    @GetMapping("/ventas/{id}/productos")
	    public List<Producto> obtenerProductosDeVenta(@PathVariable Long id) {
	        List<Producto> productos = venta.findVentaProductos(id);
	        return productos;
	    }
	    
	    @DeleteMapping ("/Venta/borrar/{id}")
	    public String deleteVenta(@PathVariable Long id) {
	    	venta.deleteventa(id);
	        return "venta eliminado correctamente";
	        }
	    @PutMapping ("/venta/editar/{id_original}")
	    public Venta edidProducto (@PathVariable Long id_original,
	            @RequestParam(required = false, name = "fecha") LocalDate nuevafecha,
	            @RequestParam(required = false, name = "total") Double nuevototal,
	            @RequestParam(required = false, name = "listaProductos") List<Producto> nuevalistaProductos,
	            @RequestParam(required = false, name = "uncliente") Cliente nuevoCliente) {
	            //midiicamos el producto
	    	venta.edidVenta(id_original, nuevafecha, nuevototal, nuevalistaProductos, nuevoCliente);
	        //buscamos el producto modificado 
	        Venta venta =this.venta.findVenta(id_original);
	        //se lo enviamos a usuario
	        return venta;
	    }
	

}
