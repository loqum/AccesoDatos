package com.rfm.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.rfm.model.Persona;

public interface Factory {
	
	public File createFile(String fileName) throws IOException;
	public File writeFile(List<Persona> personas) throws IOException;
	public String readFile() throws IOException;

}
