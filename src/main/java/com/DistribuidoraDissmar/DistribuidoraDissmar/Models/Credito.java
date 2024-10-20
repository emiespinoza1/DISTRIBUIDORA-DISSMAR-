package com.DistribuidoraDissmar.DistribuidoraDissmar.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id_credit", "id_cliente", "tipo_credit", "plazo_pago", "tasa_inters", "Fecha_venc", "monto_cred", "limit_cred"})

@Entity
@Getter
@Setter
public class Credito {
    @Id

    @JsonProperty("id_credit")
   private int  id_Credit;

   @JsonProperty("id_cliente")
  private int id_Cliente;

  @JsonProperty("tipo_credit")
  private String Tipo_credit;

  @JsonProperty("plazo_pago")
  private int Plazo_pago;

  @JsonProperty("tasa_inters")
 private double Tasa_inters;

 @JsonProperty("Fecha_venc")
  private Date fecha_venc;

  @JsonProperty("monto_cred")
  private double Monto_cred;

  @JsonProperty("limit_cred")
  private int Limit_cred;


  // Constructor vacío
  public Credito (){


  }


// Constructor con todos los campos
public Credito (int id_cliente, String tipo_credit, int plazo_pago, double tasa_inters, Date Fecha_venc, double monto_cred, int limit_cred){
    this.id_Cliente = id_cliente;
    this.Tipo_credit = tipo_credit;
    this.Plazo_pago = plazo_pago;
    this.Tasa_inters = tasa_inters;
    this.fecha_venc = Fecha_venc;
    this.Monto_cred = monto_cred;
    this.Limit_cred = limit_cred;
}

  // Constructor con el ID incluido
public Credito (int id_credit, int id_cliente, String tipo_credit, int plazo_pago, double tasa_inters, Date Fecha_venc, double monto_cred, int limit_cred){
   this.id_Credit = id_credit;
    this.id_Cliente = id_cliente;
    this.Tipo_credit = tipo_credit;
    this.Plazo_pago = plazo_pago;
    this.Tasa_inters = tasa_inters;
    this.fecha_venc = Fecha_venc;
    this.Monto_cred = monto_cred;
    this.Limit_cred = limit_cred;
}

}
