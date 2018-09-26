package com.rfm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.rfm.model.Persona;

public class FactoryBinary implements Factory {
	private static final long serialVersionUID = 7864973184904644897L;

	File file = null;
	FileOutputStream fileOutput = null;
	FileInputStream fileInput = null;
	ObjectOutputStream objectOutput = null;
	ObjectInputStream objectInput = null;
	Persona persona = null;

	public FactoryBinary() {
		super();
	}

	@Override
	public File writeFile(String fileName, List<?> usuarios) throws IOException {

		file = FactoryUtil.create(fileName);

		try {
			fileOutput = new FileOutputStream(file);
			objectOutput = new ObjectOutputStream(fileOutput);

			objectOutput.writeObject(usuarios.toString());

		} catch (IOException e) {
			e.printStackTrace();
			throw e;

		} finally {

			try {

				if (fileOutput != null) {
					fileOutput.close();
				}

				if (objectOutput != null) {
					objectOutput.close();
				}

			} catch (IOException e2) {
				e2.printStackTrace();
				throw e2;
			}

		}
		return file;
	}

	@Override
	public String readFile(String fileName) throws IOException, ClassNotFoundException {

		String leidos = null;

		try {

			fileInput = new FileInputStream(fileName);

			objectInput = new ObjectInputStream(fileInput);

			while (fileInput.available() > 0) {
				leidos = (String) objectInput.readObject();
				System.out.println(leidos);
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw e;

		} finally {
			try {
				if (fileInput != null) {
					fileInput.close();
				}

				if (objectInput != null) {
					objectInput.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
				throw e2;
			}

		}
		return leidos;

	}

}
