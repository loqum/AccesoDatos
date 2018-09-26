package com.rfm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.rfm.model.Persona;

public class FactoryTxt implements Factory {

	FactoryUtil createFile = new FactoryUtil();
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;
	FileWriter fileWriter = null;
	PrintWriter printWriter = null;
	File file = null;
	Persona persona = null;

	public FactoryTxt() {
		super();
	}

	@Override
	public File createFile(String fileName) throws IOException {
		file = FactoryUtil.create(fileName);
		return file;
	}

	@Override
	public File writeFile(List<Persona> personas) throws IOException {
		
		try {
			fileWriter = new FileWriter(file, true);
			printWriter = new PrintWriter(fileWriter);

			for (int i = 0; i <= personas.size(); i++) {
				printWriter.println(personas.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				if (null != fileWriter) {
					fileWriter.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
				throw e2;
			}
		}

		return file;
	}

	@Override
	public String readFile() throws IOException {
		String linea;

		try {
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while ((linea = bufferedReader.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e1) {
			e1.printStackTrace();
			throw e1;

		} finally {
			try {

				if (null != fileReader) {
					fileReader.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				throw e2;
			}
		}

		return linea;
	}

}
