package com.rfm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.rfm.model.Persona;

public class FactoryPersonaTxt implements FactoryPersona {

	FactoryUtil createFile = new FactoryUtil();
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;
	FileWriter fileWriter = null;
	PrintWriter printWriter = null;
	File file = null;
	Persona persona = null;

	public FactoryPersonaTxt() {
		super();
	}

	@Override
	public File createFile() throws IOException {
		file = FactoryUtil.create("fileTxt.txt");
		return file;
	}

	@Override
	public File writeFile() throws IOException {

		try {
			fileWriter = new FileWriter(file, true);
			printWriter = new PrintWriter(fileWriter);

			for (int i = 0; i <= 5; i++) {
				printWriter.println("Línea" + i);
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
			file = createFile();
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
