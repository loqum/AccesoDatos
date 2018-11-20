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

  private boolean nombre;
  private boolean apellidos;
  private boolean edad;
  private boolean telefono;
  private boolean provincia;
  private boolean pais;

  private Alumno alumno = new Alumno();
  private List<Alumno> alumnos = new ArrayList<>();

  @Override
  public void startElement(String uri, String localName, String name, Attributes attributes)
      throws SAXException {

    if (name.equals(AlumnosElement.NOMBRE.getNombre())) {
      nombre = true;
    }

    if (name.equals(AlumnosElement.APELLIDOS.getNombre())) {
      apellidos = true;
    }

    if (name.equals(AlumnosElement.EDAD.getNombre())) {
      edad = true;
    }

    if (name.equals(AlumnosElement.TELEFONO.getNombre())) {
      telefono = true;
    }

    if (name.equals(AlumnosElement.PROVINCIA.getNombre())) {
      provincia = true;
    }

    if (name.equals(AlumnosElement.PAIS.getNombre())) {
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
  public void endElement(String uri, String localName, String name) throws SAXException {
    if (name.equals(AlumnosElement.NOMBRE.getNombre())) {
      alumnos.add(alumno);
      alumno = new Alumno();
    }

  }

  public List<Alumno> saveList() {
    return alumnos;
  }

  public static void parser() throws ParserConfigurationException {

    try {

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      ReadXmlSax handler = new ReadXmlSax();
      saxParser.parse("src/main/resources/prueba.xml", handler);
      List<Alumno> list = handler.saveList();

      for (Alumno alumnos : list) {
        System.out.println("Nombre: " + alumnos.getNombre());
        System.out.println("Edad: " + alumnos.getEdad());
        System.out.println("Teléfono: " + alumnos.getTelefono());
        System.out.println("Provincia: " + alumnos.getProvincia());
        System.out.println("País: " + alumnos.getPais());
        System.out.println(
            "----------------------------------------------------------------------------");
      }

    } catch (SAXException | IOException e) {
      System.err.println("Error: " + e);
    }

  }

}
