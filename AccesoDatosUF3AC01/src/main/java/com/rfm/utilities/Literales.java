package com.rfm.utilities;

public class Literales {

  private Literales() {
    throw new IllegalStateException("Utility Class");
  }

  private static final String PERSONA = "Persona";
  private static final String NOMBRE = "nombre";
  private static final String APELLIDOS = "apellidos";
  private static final String EDAD = "edad";
  private static final String TELEFONO = "telefono";
  private static final String PROVINCIA = "provincia";
  private static final String PAIS = "pais";
  private static final String ESPANYA = "España";
  private static final String FORMAT = "\t\n\t";

  public static String getPersona() {
    return PERSONA;
  }

  public static String getNombre() {
    return NOMBRE;
  }

  public static String getApellidos() {
    return APELLIDOS;
  }

  public static String getEdad() {
    return EDAD;
  }

  public static String getTelefono() {
    return TELEFONO;
  }

  public static String getProvincia() {
    return PROVINCIA;
  }

  public static String getPais() {
    return PAIS;
  }

  public static String getEspanya() {
    return ESPANYA;
  }

  public static String getFormat() {
    return FORMAT;
  }

}
