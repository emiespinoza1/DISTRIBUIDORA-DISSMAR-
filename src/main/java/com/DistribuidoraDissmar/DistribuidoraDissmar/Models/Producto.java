package com.DistribuidoraDissmar.DistribuidoraDissmar.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id_product", "nombre_product", "descripcion", "categoria", "precio_unit", "Stock" })

@Entity
@Getter
@Setter
public class Producto {

    @Id
    @JsonProperty("id_product")
    private int id_Product;
    
    @JsonProperty("nombre_product")
    private String Nombre_product;
    
    @JsonProperty("descripcion")
    private String Descripcion;
    
    @JsonProperty("categoria")
    private String Categoria;
    
    @JsonProperty("precio_unit")
    private float Precio_unit;
    
    @JsonProperty("Stock")
    private int stock;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con todos los campos
    public Producto(String nombre_product, String descripcion, String categoria, float precio_unit, int Stock) {
        this.Nombre_product = nombre_product;
        this.Descripcion = descripcion;
        this.Categoria = categoria;
        this.Precio_unit = precio_unit;
        this.stock = Stock;
    }

    // Constructor con el ID incluido
    public Producto(int id_product, String nombre_product, String descripcion, String categoria, float precio_unit, int Stock) {
        this.id_Product = id_product;
        this.Nombre_product = nombre_product;
        this.Descripcion = descripcion;
        this.Categoria = categoria;
        this.Precio_unit = precio_unit;
        this.stock = Stock;
    }
}
