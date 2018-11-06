package com.rfm.model;

public class Persona {

  String nombre;
  String apellidos;
  int edad;
  int telefono;
  String provincia;
  String pais;

  public Persona(String nombre, String apellidos, int edad, 
      int telefono, String provincia, String pais) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.telefono = telefono;
    this.provincia = provincia;
    this.pais = pais;
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

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
    result = prime * result + telefono;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Persona other = (Persona) obj;
    if (apellidos == null) {
      if (other.apellidos != null) {
        return false;
      }
    } else if (!apellidos.equals(other.apellidos)) {
      return false;
    }
    if (telefono != other.telefono) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Persona [nombre=");
    builder.append(nombre);
    builder.append(", apellidos=");
    builder.append(apellidos);
    builder.append(", edad=");
    builder.append(edad);
    builder.append(", telefono=");
    builder.append(telefono);
    builder.append(", provincia=");
    builder.append(provincia);
    builder.append(", pais=");
    builder.append(pais);
    builder.append("]");
    return builder.toString();
  }

}
