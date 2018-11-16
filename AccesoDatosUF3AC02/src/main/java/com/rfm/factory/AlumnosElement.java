package com.rfm.factory;

public enum AlumnosElement {

  NOMBRE("nombre"), APELLIDOS("apellidos"), EDAD("edad"), TELEFONO("telefono"),
  PROVINCIA("provincia"), PAIS("pais");

  private String nombre;

  private AlumnosElement(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }
}
