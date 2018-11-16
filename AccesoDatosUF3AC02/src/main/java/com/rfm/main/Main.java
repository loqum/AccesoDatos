package com.rfm.main;

import com.rfm.factory.ReadXmlSax;

import javax.xml.parsers.ParserConfigurationException;

public class Main {

  public static void main(String[] args) {
    try {
      ReadXmlSax.parser();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
  }

}
