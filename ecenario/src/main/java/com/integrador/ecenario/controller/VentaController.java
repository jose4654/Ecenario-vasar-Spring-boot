	package com.integrador.ecenario.controller;

import java.time.LocalDate;
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

import com.integrador.ecenario.dto.ClienteProducVentaDTO;
import com.integrador.ecenario.model.Cliente;
import com.integrador.ecenario.model.Producto;
import com.integrador.ecenario.model.Venta;
import com.integrador.ecenario.service.IVentaService;

@RestController
public class VentaController {
	 @Autowired
	    private IVentaService venta;

	    @PostMapping("/Venta/crear")
	    public ResponseEntity<String> saveVenta(@RequestBody Venta venta) {
	        this.venta.saveVenta(venta);
	        return ResponseEntity.status(HttpStatus.CREATED).body("La venta fue creada correctamente");
	    }

	    @GetMapping("/Ventas")
	    public ResponseEntity<List<Venta>> getVentas() {
	        List<Venta> lisven = venta.getVentas();
	        if (lisven == null || lisven.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	        return ResponseEntity.ok(lisven);
	    }

	    @GetMapping("/Ventas/alto")
	    public ResponseEntity<ClienteProducVentaDTO> getVentasalto() {
	        ClienteProducVentaDTO dto = venta.ventaMontoAlto();
	        if (dto == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	        return ResponseEntity.ok(dto);
	    }

	    @GetMapping("/ventas/{id}/productos")
	    public ResponseEntity<List<Producto>> obtenerProductosDeVenta(@PathVariable Long id) {
	        List<Producto> productos = venta.findVentaProductos(id);
	        if (productos == null || productos.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	        return ResponseEntity.ok(productos);
	    }

	    @DeleteMapping("/Venta/borrar/{id}")
	    public ResponseEntity<String> deleteVenta(@PathVariable Long id) {
	        boolean deleted = venta.deleteventa(id);
	        if (deleted) {
	            return ResponseEntity.ok("Venta eliminada correctamente");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la venta con ID: " + id);
	        }
	    }

	    @PutMapping("/venta/editar/{id_original}")
	    public ResponseEntity<Venta> edidProducto(@PathVariable Long id_original,
	                                               @RequestParam(required = false, name = "fecha") LocalDate nuevafecha,
	                                               @RequestParam(required = false, name = "total") Double nuevototal,
	                                               @RequestParam(required = false, name = "listaProductos") List<Producto> nuevalistaProductos,
	                                               @RequestParam(required = false, name = "uncliente") Cliente nuevoCliente) {
	        venta.edidVenta(id_original, nuevafecha, nuevototal, nuevalistaProductos, nuevoCliente);
	        Venta venta = this.venta.findVenta(id_original);
	        if (venta == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	        return ResponseEntity.ok(venta);
	    }
	

}
