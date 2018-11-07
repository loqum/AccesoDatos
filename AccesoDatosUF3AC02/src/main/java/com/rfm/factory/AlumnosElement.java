package com.rfm.factory;

public enum AlumnosElement {

  NOMBRE("nombre"), EDAD("edad");

  private String nombre;

  private AlumnosElement(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }
}
