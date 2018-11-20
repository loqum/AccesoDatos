package com.rfm.main;

import com.rfm.factory.ReadXmlSax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

  private static ReadXmlSax readSax = new ReadXmlSax();

  public static void main(String[] args)
      throws ParserConfigurationException, SAXException, IOException {
    try {
      ReadXmlSax.parser();
    } catch (ParserConfigurationException e) {
      System.err.println("Error: " + e);
      throw e;
    }

    System.out.println(readSax.saveList());

  }

}
