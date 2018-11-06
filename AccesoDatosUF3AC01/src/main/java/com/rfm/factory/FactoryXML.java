package com.rfm.factory;

import java.util.List;

public class FactoryXML implements Factory {

  public FactoryXML() {
    super();
  }

  @Override
  public void readFile(String fileName, List<?> list) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void writeFile(String fileName) {

  }

}
