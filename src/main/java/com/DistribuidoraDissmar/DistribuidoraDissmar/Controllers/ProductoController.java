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

import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Producto;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.IProductoServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ProductoController")
public class ProductoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    IProductoServices productoServices;
    /*Inyección de dependencias, productoServices se comportará como
    IProductoServices*/

    // Endpoint para crear un nuevo producto
    @PostMapping("/insertarproducto")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        try {
            Producto createdProducto = productoServices.createProducto(producto);
            return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para eliminar un producto por ID
    @DeleteMapping("/eliminarproducto/{id}")
    public ResponseEntity<HashMap<String, String>> deleteProducto(@PathVariable int id) {
        try {
            HashMap<String, String> response = productoServices.deleteProducto(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para listar todos los productos
    @GetMapping("/listarproductos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        try {
            List<Producto> productos = productoServices.getAllProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar un producto
    @PutMapping("/actualizarproducto")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        try {
            Producto updatedProducto = productoServices.updateProducto(producto);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el producto: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el producto: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}





