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

import com.integrador.ecenario.model.Cliente;

import com.integrador.ecenario.service.IClienteService;


@RestController
public class ClienteController {

	 @Autowired
	    private IClienteService clienteservis;

	 
	 //crear cliente 

	 
	    @PostMapping("/Cliente/crear")
	    public ResponseEntity<String> saveCliente(@RequestBody Cliente cliente) {
	        if (cliente == null || cliente.getNombre() == null || cliente.getApellido() == null || cliente.getDni() == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos del cliente no pueden ser nulos");
	        }

	        clienteservis.saveCliente(cliente);
	        return ResponseEntity.status(HttpStatus.CREATED).body("La cliente  fue creada correctamente");
	    }
	 //ver clientes
	    @GetMapping("/Clientes")
	    public ResponseEntity<?> getClient() {
	        List<Cliente> clientes = clienteservis.getClientes();
	        if (clientes == null || clientes.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron clientes");
	        }
	        return ResponseEntity.ok(clientes);
	    }

	    
	    
	    @DeleteMapping("/Clientes/borrar/{id}")
	    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
	    	//busca al cliente si esta registrado en la base de datos 
	        if (clienteservis.findCliente(id) == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un cliente con el ID proporcionado");
	        }

	        clienteservis.deleteCliente(id);
	        return ResponseEntity.status(HttpStatus.OK).body("Cliente eliminado correctamente");
	    }
	     //editar cliente
	    @PutMapping("/Clientes/editar/{id_original}")
	    public ResponseEntity<Cliente> editarCliente(@PathVariable Long id_original,
	                                                 @RequestParam(required = false, name = "nombre") String nuevoNombre,
	                                                 @RequestParam(required = false, name = "apellido") String nuevoApellido,
	                                                 @RequestParam(required = false, name = "dni") String nuevoDni) {
	        Cliente clienteExistente = clienteservis.findCliente(id_original);
        //verifica que el cliente no sea null
	        if (clienteExistente == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }

	        Cliente clienteModificado = clienteservis.edidCliente(id_original, nuevoNombre, nuevoApellido, nuevoDni);
             //verifica que el clinte que se modifico no sea null
	        if (clienteModificado == null) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }

	        return ResponseEntity.ok(clienteModificado);
	    }
	    
}
