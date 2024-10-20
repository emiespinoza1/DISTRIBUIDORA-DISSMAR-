package com.DistribuidoraDissmar.DistribuidoraDissmar.Repository;
import java.util.List;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Producto;
import java.util.HashMap;

public interface IProductoServices {
    
    public Producto createProducto(Producto producto);

    public HashMap<String, String> deleteProducto(int id);

    public List<Producto> getAllProductos(); // Método para listar

    public Producto updateProducto(Producto producto);
}
   


