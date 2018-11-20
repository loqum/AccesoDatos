package com.rfm.factory;

import com.rfm.modelo.Alumno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXmlSax extends DefaultHandler {

  private boolean nombre = false;
  private boolean apellidos = false;
  private boolean edad = false;
  private boolean telefono = false;
  private boolean provincia = false;
  private boolean pais = false;

  private Alumno alumno = null;
  private static List<Alumno> alumnos = new ArrayList<>();

  public List<Alumno> saveList() {
    return alumnos;
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {

    if (qName.equals("Persona")) {
      alumno = new Alumno();
    }

    if (qName.equals(AlumnosElement.NOMBRE.getNombre())) {
      nombre = true;
    }

    if (qName.equals(AlumnosElement.APELLIDOS.getNombre())) {
      apellidos = true;
    }

    if (qName.equals(AlumnosElement.EDAD.getNombre())) {
      edad = true;
    }

    if (qName.equals(AlumnosElement.TELEFONO.getNombre())) {
      telefono = true;
    }

    if (qName.equals(AlumnosElement.PROVINCIA.getNombre())) {
      provincia = true;
    }

    if (qName.equals(AlumnosElement.PAIS.getNombre())) {
      pais = true;
    }

  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    if (nombre) {
      alumno.setNombre(new String(ch, start, length));
      nombre = false;
    }

    if (apellidos) {
      alumno.setApellidos(new String(ch, start, length));
      apellidos = false;
    }

    if (edad) {
      alumno.setEdad(Integer.parseInt(new String(ch, start, length)));
      edad = false;
    }

    if (telefono) {
      alumno.setTelefono(Integer.parseInt(new String(ch, start, length)));
      telefono = false;
    }

    if (provincia) {
      alumno.setProvincia(new String(ch, start, length));
      provincia = false;
    }

    if (pais) {
      alumno.setPais(new String(ch, start, length));
      pais = false;
    }

  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equals(AlumnosElement.NOMBRE.getNombre())) {
      alumnos.add(alumno);
    }

  }

  public static void parser() throws ParserConfigurationException, SAXException, IOException {

    try {

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      ReadXmlSax handler = new ReadXmlSax();
      saxParser.parse("src/main/resources/prueba.xml", handler);
      List<Alumno> list = handler.saveList();

      for (Alumno alumnos : list) {
        System.out.println("Nombre: " + alumnos.getNombre());
        System.out.println("Apellidos: " + alumnos.getApellidos());
        System.out.println("Edad: " + alumnos.getEdad());
        System.out.println("Teléfono: " + alumnos.getTelefono());
        System.out.println("Provincia: " + alumnos.getProvincia());
        System.out.println("País: " + alumnos.getPais());
        System.out.println(
            "----------------------------------------------------------------------------");
      }

    } catch (SAXException | IOException e) {
      System.err.println("Error: " + e);
      throw e;
    }

  }

}
