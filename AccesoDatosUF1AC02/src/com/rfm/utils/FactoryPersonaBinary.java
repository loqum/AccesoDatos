package com.rfm.utils;

import java.io.File;
import java.io.IOException;

import com.rfm.model.Persona;

public class FactoryPersonaBinary implements FactoryPersona {

	File file = null;
	Persona persona = null;
	
	public FactoryPersonaBinary() {
		super();
	}
	
	@Override
	public File createFile() throws IOException {
		file = FactoryUtil.create("fileBinary.txt");
		return file;
	}

	@Override
	public File writeFile() {
		

		return null;
	}

	@Override
	public String readFile() {

		return null;
	}

}
