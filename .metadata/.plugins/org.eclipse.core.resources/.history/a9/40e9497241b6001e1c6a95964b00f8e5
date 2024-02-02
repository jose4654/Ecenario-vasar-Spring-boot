package com.integrador.ecenario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ecenario.model.Cliente;
import com.integrador.ecenario.model.Producto;
import com.integrador.ecenario.repository.IClienteRepositoy;
import com.integrador.ecenario.repository.IProductoRepository;

@Service
public class ClienteService implements IClienteService{
	@Autowired
	IClienteRepositoy cliente;
	@Override
	public List<Cliente> getClientes() {
		List<Cliente>listaClientes= cliente.findAll();
		return listaClientes;
	}

	@Override
	public Cliente findCliente(Long id) {
		
		return cliente.findById(id).orElse(null);
	}

	@Override
	public void saveCliente(Cliente cliente) {
		this.cliente.save(cliente);
		
	}

	@Override
	public void deleteCliente(Long id) {
		cliente.deleteById(id);
		
	}

	@Override
	public void edidCliente(Long idOriginal, String nuevoNombre, String nuevoapellido, String nuevodni) {
		// seteamos lo atrubutos que se va resivir en un objeto productos
				Cliente cliente = this.findCliente(idOriginal);
				cliente.setApellido(nuevoapellido);
				cliente.setDni(nuevodni);
				cliente.setNombre(nuevoNombre);
				// guardamos el producto modificado en la base de datos
				this.saveCliente(cliente);;
		
	}

}
