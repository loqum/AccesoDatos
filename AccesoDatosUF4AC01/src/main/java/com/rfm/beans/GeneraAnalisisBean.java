package com.rfm.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

public class GeneraAnalisisBean implements Serializable, PropertyChangeListener {
  private static final long serialVersionUID = 1211573665564484282L;

  private int numAnalisis;
  private PacienteBean paciente;
  private Date fecha;
  private int analisisPendiente;

  public GeneraAnalisisBean() {
    
  }

  public int getNumAnalisis() {
    return numAnalisis;
  }

  public void setNumAnalisis(int numAnalisis) {
    this.numAnalisis = numAnalisis;
  }

  public PacienteBean getPaciente() {
    return paciente;
  }

  public void setPaciente(PacienteBean paciente) {
    this.paciente = paciente;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public int getAnalisisPendiente() {
    return analisisPendiente;
  }

  public void setAnalisisPendiente(int analisisPendiente) {
    this.analisisPendiente = analisisPendiente;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    System.out.printf("Nivel anterior de hierro: %f%n", Double.parseDouble(String.valueOf(evt.getOldValue())));
    System.out.printf("Nivel actual de hierro: %f%n", Double.parseDouble(String.valueOf(evt.getNewValue())));
    System.out.printf("Realizar análisis en paciente: %s-%s-%s", paciente.getDni(), paciente.getNombre(), paciente.getApellidos());
  }

}
