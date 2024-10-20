package com.DistribuidoraDissmar.DistribuidoraDissmar.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Cliente;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.IClienteServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ClienteController")
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    IClienteServices clienteServices;
    /*Inyección de dependencias, clienteServices se comportará como
    IClienteServices*/

    // Endpoint para crear un nuevo cliente
    @PostMapping("/insertarcliente")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        try {
            Cliente createdCliente = clienteServices.createCliente(cliente);
            return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para eliminar un cliente por ID
    @DeleteMapping("/eliminarcliente/{id}")
    public ResponseEntity<HashMap<String, String>> deleteCliente(@PathVariable int id) {
        try {
            HashMap<String, String> response = clienteServices.deleteCliente(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para listar todos los clientes
    @GetMapping("/listarclientes")
    public ResponseEntity<List<Cliente>> getAllCliente() {
        try {
            List<Cliente> cliente = clienteServices.getAllCliente();
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar un cliente
    @PutMapping("/actualizarcliente")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
        try {
            Cliente updatedCliente = clienteServices.updateCliente(cliente);
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el cliente: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el cliente: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}