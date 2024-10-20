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

import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Credito;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.ICreditoServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/CreditoController")
public class CreditoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditoController.class);

    @Autowired
    ICreditoServices creditoServices;
    /*Inyección de dependencias, clienteServices se comportará como
    IClienteServices*/

    // Endpoint para crear un nuevo cliente
    @PostMapping("/insertarcredito")
    public ResponseEntity<Credito> createCredito(@RequestBody Credito credito) {
        try {
            Credito createdCredito = creditoServices.createCredito(credito);
            return new ResponseEntity<>(createdCredito, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para eliminar un cliente por ID
    @DeleteMapping("/eliminarcredito/{id}")
    public ResponseEntity<HashMap<String, String>> deleteCredito(@PathVariable int id) {
        try {
            HashMap<String, String> response = creditoServices.deleteCredito(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para listar todos los clientes
    @GetMapping("/listarcredito")
    public ResponseEntity<List<Credito>> getAllCredito() {
        try {
            List<Credito> credito = creditoServices.getAllCreditos();
            return new ResponseEntity<>(credito, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar un cliente
    @PutMapping("/actualizarcredito")
    public ResponseEntity<Credito> updateCredito(@RequestBody Credito credito) {
        try {
            Credito updatedCredito = creditoServices.updateCredito(credito);
            return new ResponseEntity<>(updatedCredito, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el credito: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el credito: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}