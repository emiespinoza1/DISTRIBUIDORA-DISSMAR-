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

import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Abono;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.IAbonoServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/AbonoController")
public class AbonoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbonoController.class);

    @Autowired
    IAbonoServices abonoServices;
    /*Inyección de dependencias, abonoServices se comportará como
    IAbonoServices*/

    // Endpoint para crear un nuevo abono
    @PostMapping("/insertarabono")
    public ResponseEntity<Abono> createAbono(@RequestBody Abono abono) {
        try {
            Abono createdAbono = abonoServices.createAbono(abono);
            return new ResponseEntity<>(createdAbono, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para eliminar un abono por ID
    @DeleteMapping("/eliminarabono/{id}")
    public ResponseEntity<HashMap<String, String>> deleteAbono(@PathVariable int id) {
        try {
            HashMap<String, String> response = abonoServices.deleteAbono(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para listar todos los abonos
    @GetMapping("/listarabonos")
    public ResponseEntity<List<Abono>> getAllAbono() {
        try {
            List<Abono> abono = abonoServices.getAllAbonos();
            return new ResponseEntity<>(abono, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar un abono
    @PutMapping("/actualizarabono")
    public ResponseEntity<Abono> updateAbono(@RequestBody Abono abono) {
        try {
            Abono updatedAbono = abonoServices.updateAbono(abono);
            return new ResponseEntity<>(updatedAbono, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el abono: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el abono: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
