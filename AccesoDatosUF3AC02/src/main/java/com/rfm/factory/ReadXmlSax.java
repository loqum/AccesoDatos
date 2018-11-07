package com.rfm.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.rfm.modelo.Alumno;

public class ReadXmlSax extends DefaultHandler {

  private boolean nombre;
  private boolean edad;

  private Alumno alumno = new Alumno();
  private List<Alumno> alumnos = new ArrayList<Alumno>();

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {

    if (qName.equals(AlumnosElement.NOMBRE.getNombre())) {
      nombre = true;
    }

    if (qName.equals(AlumnosElement.EDAD.getNombre())) {
      edad = true;
    }

  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    if (nombre) {
      alumno.setNombre(new String(ch, start, length));
      nombre = false;
    }

    if (edad) {
      alumno.setEdad(Integer.parseInt(new String(ch, start, length)));
      edad = false;
    }

  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equals(AlumnosElement.NOMBRE.getNombre())) {
      alumnos.add(alumno);
      alumno = new Alumno();
    }

  }

  public List<Alumno> saveList() {
    return alumnos;
  }

  public void parser() throws ParserConfigurationException {

    try {

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      ReadXmlSax handler = new ReadXmlSax();
      saxParser.parse("src/main/resources/menu.xml", handler);
      List<Alumno> list = handler.saveList();

      for (Alumno alumnos : list) {
        System.out.println("Nombre: " + alumnos.getNombre());
        System.out.println("Edad: " + alumnos.getEdad());
        System.out.println(
            "---------------------------------------------------------------------------------------------");
      }

    } catch (SAXException | IOException e) {
      System.err.println("Error: " + e);
    }

  }

}
