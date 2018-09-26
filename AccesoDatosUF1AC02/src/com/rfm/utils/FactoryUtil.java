package com.rfm.utils;

import java.io.File;
import java.io.IOException;

public class FactoryUtil {

	public static File create(String fileName) throws IOException {

		File file = new File(fileName);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		return file;
	}

}
