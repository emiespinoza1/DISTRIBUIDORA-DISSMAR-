package com.DistribuidoraDissmar.DistribuidoraDissmar.Services;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Credito;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.CreditoRepository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.ICreditoServices;
import java.util.HashMap;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditoServices implements ICreditoServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditoServices.class);

    @Autowired
    CreditoRepository creditoRepository;

    @Override
    public Credito createCredito(Credito credito) {
        try {
            return creditoRepository.save(credito);
        } catch (Exception e) {
            LOGGER.error("Error while creating credit: {}", e.getMessage());
            throw new RuntimeException("Error creating credit");
        }
    }

    @Override
    public HashMap<String, String> deleteCredito(int id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Credit deleted successfully!");
            creditoRepository.deleteById(id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting credit: {}", e.getMessage());
            throw new RuntimeException("Error deleting credit");
        }
    }

   @Override
    public List<Credito> getAllCreditos() {
        try {
            return creditoRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching credit: {}", e.getMessage());
            throw new RuntimeException("Error fetching credit");
        }
    }

    @Transactional
    public Credito updateCredito(Credito credito) {
        if (creditoRepository.existsById(credito.getId_Credit())) {
            return creditoRepository.save(credito);
        } else {
            LOGGER.error("Credito no encontrado con ID: {}", credito.getId_Credit());
            throw new RuntimeException("Credito no encontrado");
        }
    }
}