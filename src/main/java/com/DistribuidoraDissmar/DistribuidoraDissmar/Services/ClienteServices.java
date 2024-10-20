package com.DistribuidoraDissmar.DistribuidoraDissmar.Services;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Cliente;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.ClienteRepository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.IClienteServices;
import java.util.HashMap;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServices implements IClienteServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServices.class);

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente createCliente(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            LOGGER.error("Error while creating producto: {}", e.getMessage());
            throw new RuntimeException("Error creating product");
        }
    }

    @Override
    public HashMap<String, String> deleteCliente(int id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Product deleted successfully!");
            clienteRepository.deleteById(id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting cliente: {}", e.getMessage());
            throw new RuntimeException("Error deleting cliente");
        }
    }

   @Override
    public List<Cliente> getAllCliente() {
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching productos: {}", e.getMessage());
            throw new RuntimeException("Error fetching productos");
        }
    }

    @Transactional
    public Cliente updateCliente(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getId_Cliente())) {
            return clienteRepository.save(cliente);
        } else {
            LOGGER.error("Cliente no encontrado con ID: {}", cliente.getId_Cliente());
            throw new RuntimeException("Cliente no encontrado");
        }
    }
}