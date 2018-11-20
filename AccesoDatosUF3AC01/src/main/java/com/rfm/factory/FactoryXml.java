package com.rfm.factory;

import com.rfm.utilities.Literales;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FactoryXml implements FactoryMethod {

  public FactoryXml() {
    super();
  }

  @Override
  public void readFile(String fileName, List<?> list) throws IOException, JDOMException {
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File(fileName);
    int autoNum = 1;
    
    try {
      
      Document document = builder.build(xmlFile);

      Element rootNode = document.getRootElement();

      list = rootNode.getChildren(Literales.getPersona());

      for (int i = 0; i < list.size(); i++) {
        
        Element persona = (Element) list.get(i);

        System.out.println("\nPersona " + autoNum++);

        String nombre = persona.getChildTextTrim(Literales.getNombre());
        String apellidos = persona.getChildTextTrim(Literales.getApellidos());
        String edad = persona.getChildTextTrim(Literales.getEdad());
        String telefono = persona.getChildTextTrim(Literales.getTelefono());
        String provincia = persona.getChildTextTrim(Literales.getProvincia());
        String pais = persona.getChildTextTrim(Literales.getPais());
        
        System.out.println("\tNombre: ".concat(nombre)
            .concat(Literales.getFormat()).concat("Apellidos: ")
            .concat(apellidos).concat(Literales.getFormat())
            .concat("Edad: ").concat(edad)
            .concat(Literales.getFormat()).concat("Telefono: ")
            .concat(telefono).concat(Literales.getFormat())
            .concat("Provincia: ").concat(provincia)
            .concat(Literales.getFormat()).concat("Pais: ").concat(pais));
      }

    } catch (IOException | JDOMException e) {
      System.err.println("Error: " + e);
      throw e;
    }
  }

  @Override
  public void writeFile(String fileName) throws IOException {

    try {

      Element personas = new Element("Personas");
      Document document = new Document(personas);
      document.setRootElement(personas);

      Element personaUno = new Element(Literales.getPersona());
      personaUno.addContent(new Element(Literales.getNombre()).setText("Pep"));
      personaUno.addContent(new Element(Literales.getApellidos()).setText("Claret"));
      personaUno.addContent(new Element(Literales.getEdad()).setText("32"));
      personaUno.addContent(new Element(Literales.getTelefono()).setText("654684654"));
      personaUno.addContent(new Element(Literales.getProvincia()).setText("Barcelona"));
      personaUno.addContent(new Element(Literales.getPais()).setText(Literales.getEspanya()));

      document.getRootElement().addContent(personaUno);

      Element personaDos = new Element(Literales.getPersona());
      personaDos.addContent(new Element(Literales.getNombre()).setText("Juan"));
      personaDos.addContent(new Element(Literales.getApellidos()).setText("Garcia"));
      personaDos.addContent(new Element(Literales.getEdad()).setText("39"));
      personaDos.addContent(new Element(Literales.getTelefono()).setText("654454654"));
      personaDos.addContent(new Element(Literales.getProvincia()).setText("Girona"));
      personaDos.addContent(new Element(Literales.getPais()).setText(Literales.getEspanya()));

      document.getRootElement().addContent(personaDos);

      Element personaTres = new Element(Literales.getPersona());
      personaTres.addContent(new Element(Literales.getNombre()).setText("Alfredo"));
      personaTres.addContent(new Element(Literales.getApellidos()).setText("Fernandez"));
      personaTres.addContent(new Element(Literales.getEdad()).setText("87"));
      personaTres.addContent(new Element(Literales.getTelefono()).setText("624654654"));
      personaTres.addContent(new Element(Literales.getProvincia()).setText("Huesca"));
      personaTres.addContent(new Element(Literales.getPais()).setText(Literales.getEspanya()));

      document.getRootElement().addContent(personaTres);

      Element personaCuatro = new Element(Literales.getPersona());
      personaCuatro.addContent(new Element(Literales.getNombre()).setText("Sandra"));
      personaCuatro.addContent(new Element(Literales.getApellidos()).setText("Agusti"));
      personaCuatro.addContent(new Element(Literales.getEdad()).setText("28"));
      personaCuatro.addContent(new Element(Literales.getTelefono()).setText("654654667"));
      personaCuatro.addContent(new Element(Literales.getProvincia()).setText("Caceres"));
      personaCuatro.addContent(new Element(Literales.getPais()).setText(Literales.getEspanya()));

      document.getRootElement().addContent(personaCuatro);

      Element personaCinco = new Element(Literales.getPersona());
      personaCinco.addContent(new Element(Literales.getNombre()).setText("Marta"));
      personaCinco.addContent(new Element(Literales.getApellidos()).setText("Sanchez"));
      personaCinco.addContent(new Element(Literales.getEdad()).setText("23"));
      personaCinco.addContent(new Element(Literales.getTelefono()).setText("654689654"));
      personaCinco.addContent(new Element(Literales.getProvincia()).setText("Madrid"));
      personaCinco.addContent(new Element(Literales.getPais()).setText(Literales.getEspanya()));

      document.getRootElement().addContent(personaCinco);

      XMLOutputter xmlOutput = new XMLOutputter();

      xmlOutput.setFormat(Format.getPrettyFormat());

      xmlOutput.output(document, new FileWriter(fileName));

      System.out.println("Archivo guardado!");

    } catch (IOException e) {
      System.err.println("Error en la creacion del archivo: " + e);
      throw e;
    }

  }

}
