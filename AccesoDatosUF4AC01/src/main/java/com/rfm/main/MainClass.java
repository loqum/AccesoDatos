package com.rfm.main;

import com.rfm.beans.GeneraAnalisisBean;
import com.rfm.beans.PacienteBean;

public class MainClass {

  public static void main(String[] args) {
    
    PacienteBean paciente = new PacienteBean("Pepe", "García-Aguado", "78456321J", 45, 654654654,
        8.021, 15);
    GeneraAnalisisBean generaAnalisis = new GeneraAnalisisBean();
    
    generaAnalisis.setPaciente(paciente);
    
    paciente.getPropertyChangeSupport().addPropertyChangeListener(generaAnalisis);
    
    paciente.setNivelHierro(10.01);
    
    
  }

}
