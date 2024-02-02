package com.integrador.ecenario.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ecenario.dto.ClienteProducVentaDTO;
import com.integrador.ecenario.model.Cliente;
import com.integrador.ecenario.model.Producto;
import com.integrador.ecenario.model.Venta;
import com.integrador.ecenario.repository.IVentaRepository;
@Service
public class VentaService implements IVentaService{
	@Autowired
	IVentaRepository venta;
	@Override
	public List<Venta> getVentas() {
	List<Venta>listaVentas=venta.findAll();
		return listaVentas;
	}

	@Override
	public Venta findVenta(Long id) {
		
		return venta.findById(id).orElse(null);
	}

	@Override
	public void saveVenta(Venta venta) {
		this.venta.save(venta);
		
	}

	@Override
	public void deleteventa(Long id) {
		venta.deleteById(id);
		
	}

	@Override
	public void edidVenta(Long idOriginal, LocalDate fecha, Double total, List<Producto> listaProductos,
			Cliente uncliente) {
		// seteamos lo atrubutos que se va resivir en un objeto productos
		Venta venta = this.findVenta(idOriginal);
		venta.setFecha(fecha);
		venta.setListaProductos(listaProductos);
		venta.setTotal(total);
		venta.setUncliente(uncliente);
		
		// guardamos el producto modificado en la base de datos
		this.saveVenta(venta);
		
	}

	@Override
	public List<Producto> findVentaProductos(Long id) {
	    List<Producto> ProductoVent = new ArrayList<>();
	    Venta venta = this.findVenta(id);

	    if (venta != null) {
	        List<Producto> listaProductos = venta.getListaProductos();

	        for (Producto p : listaProductos) {
	            ProductoVent.add(p);
	        }
	    }

	    return ProductoVent;
	}
 // este metodo no vca dar la mventa mas alta 
	@Override
	public ClienteProducVentaDTO ventaMontoAlto() {
	    ClienteProducVentaDTO clienteproduventa = new ClienteProducVentaDTO(); // Inicializa el DTO

	    double ventaConTotalMasAlto = 0;
	    List<Venta> ventas = this.getVentas();

	    for (Venta venta : ventas) {
	        if (venta.getTotal() > ventaConTotalMasAlto) {
	            // Actualiza la venta con el total más alto y su información correspondiente
	            ventaConTotalMasAlto = venta.getTotal();

	            clienteproduventa.setApellido_cliente(venta.getUncliente().getApellido());
	            clienteproduventa.setId_venta(venta.getId());
	            clienteproduventa.setNombre_cliente(venta.getUncliente().getNombre()); // Aquí podría ser el nombre en lugar del apellido
	            clienteproduventa.setTota_venta(venta.getTotal());
	            clienteproduventa.setCantidad_productos(venta.getListaProductos().size());
	        }
	    }

	    return clienteproduventa;
	}



}
