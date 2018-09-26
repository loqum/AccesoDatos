package com.rfm.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.rfm.model.Persona;

public interface FactoryPersona {
	
	public File createFile() throws IOException;
	public File writeFile() throws IOException;
	public String readFile() throws IOException;

}
