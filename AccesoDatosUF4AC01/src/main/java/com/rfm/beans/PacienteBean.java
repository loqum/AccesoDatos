package com.rfm.beans;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class PacienteBean implements Serializable {
  private static final long serialVersionUID = -1213708389497746425L;

  private String nombre;
  private String apellidos;
  private String dni;
  private int edad;
  private int telefono;
  private double nivelHierro;
  private double nivelUrea;
  private PropertyChangeSupport propertyChangeSupport;

  public PacienteBean() {
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public PacienteBean(String nombre, String apellidos, String dni, int edad, int telefono,
      double nivelHierro, double nivelUrea) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dni = dni;
    this.edad = edad;
    this.telefono = telefono;
    this.nivelHierro = nivelHierro;
    this.nivelUrea = nivelUrea;
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }

  public double getNivelHierro() {
    return nivelHierro;
  }

  public void setNivelHierro(double nivelHierro) {
    double nivelAnteriorHierro = this.nivelHierro;
    this.nivelHierro = nivelHierro;

    if (this.nivelHierro > 10) {
      propertyChangeSupport.firePropertyChange("nivelHierro", nivelAnteriorHierro,
          this.nivelHierro);
      this.nivelHierro = nivelAnteriorHierro;
    }
  }

  public double getNivelUrea() {
    return nivelUrea;
  }

  public void setNivelUrea(double nivelUrea) {
    this.nivelUrea = nivelUrea;
  }

  public PropertyChangeSupport getPropertyChangeSupport() {
    return propertyChangeSupport;
  }

  public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
    this.propertyChangeSupport = propertyChangeSupport;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("PacienteBean [nombre=");
    builder.append(nombre);
    builder.append(", apellidos=");
    builder.append(apellidos);
    builder.append(", dni=");
    builder.append(dni);
    builder.append(", edad=");
    builder.append(edad);
    builder.append(", telefono=");
    builder.append(telefono);
    builder.append(", nivelHierro=");
    builder.append(nivelHierro);
    builder.append(", nivelUrea=");
    builder.append(nivelUrea);
    builder.append("]");
    return builder.toString();
  }

}
