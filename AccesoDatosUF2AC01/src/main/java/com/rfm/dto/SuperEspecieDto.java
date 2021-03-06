package com.rfm.dto;

public class SuperEspecieDto {

  private long idSuperEspecie;
  private String nombre;

  public SuperEspecieDto(long idSuperEspecie, String nombre) {
    this.idSuperEspecie = idSuperEspecie;
    this.nombre = nombre;
  }

  public SuperEspecieDto() {

  }

  public long getIdSuperEspecie() {
    return idSuperEspecie;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (idSuperEspecie ^ (idSuperEspecie >>> 32));
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
    SuperEspecieDto other = (SuperEspecieDto) obj;
    if (idSuperEspecie != other.idSuperEspecie) {
      return false;
    }
    if (nombre == null) {
      if (other.nombre != null) {
        return false;
      }
    } else if (!nombre.equals(other.nombre)) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SuperEspecie [idSuperEspecie=");
    builder.append(idSuperEspecie);
    builder.append(", nombre=");
    builder.append(nombre);
    builder.append("]");
    return builder.toString();
  }

}
