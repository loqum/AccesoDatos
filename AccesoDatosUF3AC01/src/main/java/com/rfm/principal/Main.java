package com.rfm.principal;

import com.rfm.factory.FactoryXml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static FactoryXml factoryXml = new FactoryXml();
  private static List<?> list = new ArrayList<>();

  public static void main(String[] args) {

    try {

      factoryXml.writeFile("prueba.xml");
      factoryXml.readFile("prueba.xml", list);

    } catch (IOException e) {

      System.err.println("Error: " + e);
    }

  }

}
