package com.rfm.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.rfm.model.Persona;

public class FactoryBinary implements Factory {

	File file = null;
	Persona persona = null;
	
	public FactoryBinary() {
		super();
	}
	

	@Override
	public File writeFile(String fileName, List<Persona> personas) throws IOException {
		

		return null;
	}

	@Override
	public String readFile(String fileName) throws IOException {

		return null;
	}

}
