package com.rfm.principal;

import com.rfm.factory.FactoryXml;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    FactoryXml factoryXml = new FactoryXml();
    try {
      factoryXml.writeFile("prueba.xml");
    } catch (IOException e) {
      System.err.println("Error: " + e);
    }
  }

}
