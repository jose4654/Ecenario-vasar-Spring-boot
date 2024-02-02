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

import com.integrador.ecenario.model.Cliente;

import com.integrador.ecenario.service.IClienteService;


@RestController
public class ClienteController {

	 @Autowired
	    private IClienteService clienteservis;
	 
	 @PostMapping ("/Cliente/crear")
	    public String saveProducto (@RequestBody Cliente cliente) {
		 clienteservis.saveCliente(cliente);
	        
	        return "La persona fue creada correctamente";
	    }
	    @GetMapping ("/Clientes")
	    public List<Cliente> getPoductos() {
	        
	        return clienteservis.getClientes();
	    }
	    
	    
	    
	    @DeleteMapping ("/Clientes/borrar/{id}")
	    public String deletePersona(@PathVariable Long id) {
	    	clienteservis.deleteCliente(id);
	        return "Cliente eliminado correctamente";
	    }
	    
	    @PutMapping ("/Cliente/editar/{id_original}")
	    public Cliente edidProducto (@PathVariable Long id_original,
	            @RequestParam(required = false, name = "nombre") String nuevoNombre,
	            @RequestParam(required = false, name = "apellido") String nuevoapellido,
	            @RequestParam(required = false, name = "dni") String nuevoDni) {
	            //midiicamos el producto
	    	clienteservis.edidCliente(id_original, nuevoNombre, nuevoapellido, nuevoDni);
	        //buscamos el producto modificado 
	        Cliente produ = clienteservis.findCliente(id_original);
	        //se lo enviamos a usuario
	        return produ;

	    }
	    
}
