package com.DistribuidoraDissmar.DistribuidoraDissmar.Services;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Producto;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.ProductoRepository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.IProductoServices;
import java.util.HashMap;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServices implements IProductoServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoServices.class);

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto createProducto(Producto producto) {
        try {
            return productoRepository.save(producto);
        } catch (Exception e) {
            LOGGER.error("Error while creating producto: {}", e.getMessage());
            throw new RuntimeException("Error creating product");
        }
    }

    @Override
    public HashMap<String, String> deleteProducto(int id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Product deleted successfully!");
            productoRepository.deleteById(id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting product: {}", e.getMessage());
            throw new RuntimeException("Error deleting product");
        }
    }

    @Override
    public List<Producto> getAllProductos() {
        try {
            return productoRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching productos: {}", e.getMessage());
            throw new RuntimeException("Error fetching productos");
        }
    }

    @Transactional
    public Producto updateProducto(Producto producto) {
        if (productoRepository.existsById(producto.getId_Product())) {
            return productoRepository.save(producto);
        } else {
            LOGGER.error("Producto no encontrado con ID: {}", producto.getId_Product());
            throw new RuntimeException("Producto no encontrado");
        }
    }
}