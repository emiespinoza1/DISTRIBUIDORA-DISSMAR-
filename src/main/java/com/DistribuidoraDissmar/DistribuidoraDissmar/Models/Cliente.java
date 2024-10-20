package com.DistribuidoraDissmar.DistribuidoraDissmar.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id_cliente", "nombre", "apellido", "celular", "direccion", "cedula" })

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @JsonProperty("id_cliente")
    private int id_Cliente;
    
    @JsonProperty("nombre")
    private String Nombre;
    
    @JsonProperty("apellido")
    private String Apellido;
    
    @JsonProperty("celular")
    private String Celular;
    
    @JsonProperty("direccion")
    private String Direccion;
    
    @JsonProperty("cedula")
    private String Cedula;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con todos los campos
    public Cliente(String nombre, String apellido, String celular, String direccion, String cedula) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Celular = celular;
        this.Direccion = direccion;
        this.Cedula = cedula;
    }

    // Constructor con el ID incluido
    public Cliente(int id_cliente, String nombre, String apellido, String celular, String direccion, String cedula) {
      this.id_Cliente = id_cliente; 
      this.Nombre = nombre;
      this.Apellido = apellido;
      this.Celular = celular;
      this.Direccion = direccion;
      this.Cedula = cedula;
}
}