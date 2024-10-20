package com.DistribuidoraDissmar.DistribuidoraDissmar.Repository;
import java.util.List;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Abono;
import java.util.HashMap;

public interface IAbonoServices {
    
    public Abono createAbono(Abono abono);

    public HashMap<String, String> deleteAbono(int id);

    public List<Abono> getAllAbonos(); // Método para listar

    public Abono updateAbono(Abono abono);
}

