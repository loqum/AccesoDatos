package com.rfm.factory;

import java.io.IOException;
import java.util.List;

import org.jdom.JDOMException;

public interface FactoryMethod {

  public void readFile(String fileName, List<?> list) throws IOException, JDOMException;

  public void writeFile(String fileName) throws IOException;

}
