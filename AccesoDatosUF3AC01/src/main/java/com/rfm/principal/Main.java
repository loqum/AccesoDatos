package com.rfm.principal;

import com.rfm.factory.FactoryMethod;
import com.rfm.factory.FactoryXml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.JDOMException;

public class Main {

  private static FactoryMethod factoryXml = new FactoryXml();
  private static List<?> list = new ArrayList<>();

  /**
   * Punto de entrada a la aplicacion.
   * 
   * @param args Por defecto.
   * @throws IOException   Signals that an I/O exception of some sort has
   *                       occurred. This class is the general class of exceptions
   *                       produced by failed or interrupted I/O operations.
   * 
   * @throws JDOMException The top level 'checked' exception that JDOM classes can
   *                       throw. JDOM does throw a number of unchecked
   *                       exceptions, but all the checked exceptions are
   *                       descendants of this class.
   * 
   */

  public static void main(String[] args) throws IOException, JDOMException {

    try {

      factoryXml.writeFile("src/main/resources/prueba.xml");
      factoryXml.readFile("src/main/resources/prueba.xml", list);

    } catch (IOException e) {
      System.err.println("Error: " + e);
      throw e;
    }

  }

}
