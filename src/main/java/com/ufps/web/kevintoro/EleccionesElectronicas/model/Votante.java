package com.ufps.web.kevintoro.EleccionesElectronicas.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Votante implements Serializable {
  private int id;
  private String nombre;
  private String email;
  private String documento;
  private int tipoDocumento;
  private int eleccion;
  
  public Votante(int id, String nombre, String email, String documento, int tipoDocumento, int eleccion) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.documento = documento;
    this.tipoDocumento = tipoDocumento;
    this.eleccion = eleccion;
  }
  
  public Votante(String nombre, String email, String documento, int tipoDocumento, int eleccion) {
    this.nombre = nombre;
    this.email = email;
    this.documento = documento;
    this.tipoDocumento = tipoDocumento;
    this.eleccion = eleccion;
  }
}
