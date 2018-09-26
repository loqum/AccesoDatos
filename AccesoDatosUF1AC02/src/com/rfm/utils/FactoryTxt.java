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
	private static final long serialVersionUID = 2385994570516030149L;

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
	public File writeFile(String fileName, List<?> personas) throws IOException {

		file = FactoryUtil.create(fileName);

		try {
			fileWriter = new FileWriter(file);
			printWriter = new PrintWriter(fileWriter);

			printWriter.println(personas.toString());

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
	public String readFile(String fileName) throws IOException {

		String linea;

		try {
			fileReader = new FileReader(fileName);
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
