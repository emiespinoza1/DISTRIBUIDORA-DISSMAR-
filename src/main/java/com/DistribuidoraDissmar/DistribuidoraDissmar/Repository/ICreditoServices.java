package com.DistribuidoraDissmar.DistribuidoraDissmar.Repository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Credito;


import java.util.List;

import java.util.HashMap;


public interface ICreditoServices {

    public Credito createCredito(Credito credito);

    public HashMap<String, String> deleteCredito(int id);

    public List<Credito> getAllCreditos(); // Método para listar

    public Credito updateCredito(Credito credito);
        

}
