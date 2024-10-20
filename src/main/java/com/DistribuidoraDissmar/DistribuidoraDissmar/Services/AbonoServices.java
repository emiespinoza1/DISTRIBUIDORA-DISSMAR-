package com.DistribuidoraDissmar.DistribuidoraDissmar.Services;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Abono;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.AbonoRepository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Repository.IAbonoServices;
import java.util.HashMap;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbonoServices implements IAbonoServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServices.class);

    @Autowired
    AbonoRepository abonoRepository;

    @Override
    public Abono createAbono(Abono abono) {
        try {
            return abonoRepository.save(abono);
        } catch (Exception e) {
            LOGGER.error("Error while creating abono: {}", e.getMessage());
            throw new RuntimeException("Error creating abono");
        }
    }

    @Override
    public HashMap<String, String> deleteAbono(int id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Abono deleted successfully!");
            abonoRepository.deleteById(id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting abono: {}", e.getMessage());
            throw new RuntimeException("Error deleting abono");
        }
    }

   @Override
    public List<Abono> getAllAbonos() {
        try {
            return abonoRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching abonos: {}", e.getMessage());
            throw new RuntimeException("Error fetching abonos");
        }
    }

    @Transactional
    public Abono updateAbono(Abono abono) {
        if (abonoRepository.existsById(abono.getId_Abono())) {
            return abonoRepository.save(abono);
        } else {
            LOGGER.error("Abono no encontrado con ID: {}", abono.getId_Abono());
            throw new RuntimeException("Abono no encontrado");
        }
    }
}
