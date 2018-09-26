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
	public File createFile(String fileName) throws IOException {
		file = FactoryUtil.create(fileName);
		return file;
	}

	@Override
	public File writeFile(List<Persona> personas) {
		

		return null;
	}

	@Override
	public String readFile() {

		return null;
	}

}
