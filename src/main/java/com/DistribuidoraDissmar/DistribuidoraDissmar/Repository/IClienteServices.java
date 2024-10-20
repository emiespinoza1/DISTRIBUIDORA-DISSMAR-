package com.DistribuidoraDissmar.DistribuidoraDissmar.Repository;
import java.util.List;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Cliente;
import java.util.HashMap;

public interface IClienteServices {
    
    public Cliente createCliente(Cliente cliente);

    public HashMap<String, String> deleteCliente(int id);

    public List<Cliente> getAllCliente(); // Método para listar

    public Cliente updateCliente(Cliente cliente);
}