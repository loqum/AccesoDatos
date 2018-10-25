package com.rfm.utils;

import java.util.regex.Pattern;

public class Util {
	
	private static StringBuilder builder = new StringBuilder();
	private static final StringBuilder BIENVENIDA = builder
			.append("Bienvenido")
			.append("\n")
			.append("\nElija una opcion:\n")
			.append("\n")
			.append("0. Salir del programa")
			.append("\n")
			.append("1. Crear Super Especie")
			.append("\n")
			.append("2. Añadir Super Guerrero")
			.append("\n")
			.append("3. Insertar nivel de poder en Super Guerrero")
			.append("\n")
			.append("4. Consultar")
			.append("\n")
			.append("5. Resetear Super Guerrero")
			.append("\n")
			.append("6. Eliminar Super Guerrero")
			.append("\n")
			.append("7. Eliminar Super Especie")
			.append("\n");

	public static boolean isValidNumber(String eleccion) {
		String regex = "\\d";
		Pattern pattern = Pattern.compile(regex);

		if (pattern.matcher(eleccion).matches()) {
			return true;
		} else {
			return false;
		}

	}

	public static StringBuilder getBienvenida() {
		return BIENVENIDA;
	}

}
