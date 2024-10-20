package com.DistribuidoraDissmar.DistribuidoraDissmar.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id_abono", "id_cliente", "monto", "fecha_abo"})

@Entity
@Getter
@Setter
public class Abono {

    @Id
    @JsonProperty("id_abono")
    private int id_Abono;
    
    @JsonProperty("id_cliente")
    private int id_Cliente;
    
    @JsonProperty("monto")
    private float Monto;
    
    @JsonProperty("fecha_abo")
    private Date Fecha_Abo;

    // Constructor vacío
    public Abono() {
    }

    // Constructor con todos los campos
    public Abono(int id_cliente, float monto, Date fecha_abo) {
        this.id_Cliente = id_cliente;
        this.Monto = monto;
        this.Fecha_Abo = fecha_abo;
    }

    // Constructor con el ID incluido
    public Abono(int id_abono, int id_cliente, float monto, Date fecha_abo) {
        this.id_Abono = id_abono;
        this.id_Cliente = id_cliente;
        this.Monto = monto;
        this.Fecha_Abo = fecha_abo;
    }
}
