package com.ufps.web.kevintoro.EleccionesElectronicas.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Estamento implements Serializable {
  private int id;
  private int eleccion;
  private String descripcion;
  
  public Estamento(int id, int eleccion, String descripcion) {
    this.id = id;
    this.eleccion = eleccion;
    this.descripcion = descripcion;
  }
  
  public Estamento(int eleccion, String descripcion) {
    this.eleccion = eleccion;
    this.descripcion = descripcion;
  }
}
