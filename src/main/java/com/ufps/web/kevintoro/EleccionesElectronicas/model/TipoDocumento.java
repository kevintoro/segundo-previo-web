package com.ufps.web.kevintoro.EleccionesElectronicas.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TipoDocumento implements Serializable {
  private int id;
  private String descripcion;
  
  public TipoDocumento(int id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }
  
  public TipoDocumento(String descripcion) {
    this.descripcion = descripcion;
  }
}
