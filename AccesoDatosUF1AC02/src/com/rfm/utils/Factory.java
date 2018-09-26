package com.rfm.utils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.rfm.model.Persona;

public interface Factory extends Serializable {

	public File writeFile(String fileName, List<?> lista) throws IOException;

	public String readFile(String fileName) throws IOException, ClassNotFoundException;

}
