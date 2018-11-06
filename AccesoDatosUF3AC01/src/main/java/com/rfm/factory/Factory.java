package com.rfm.factory;

import java.util.List;

public interface Factory {

  public void readFile(String fileName, List<?> list);

  public void writeFile(String fileName);

}
