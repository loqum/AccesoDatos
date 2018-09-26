package com.rfm.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.rfm.model.Persona;

public interface Factory {

	public File writeFile(String fileName, List<Persona> personas) throws IOException;

	public String readFile(String fileName) throws IOException;

}
