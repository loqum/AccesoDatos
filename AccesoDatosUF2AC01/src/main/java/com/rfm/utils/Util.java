package com.rfm.utils;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Util {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(com.rfm.utils.Util.class.getName());
	private static StringBuilder builderBienvenida = new StringBuilder();
	private static final StringBuilder BIENVENIDA = builderBienvenida
			.append("\n\n\nElija una opcion:\n")
			.append("\n")
			.append("0: Salir del programa")
			.append("\n")
			.append("1: Crear Super Especie")
			.append("\n")
			.append("2: Añadir Super Guerrero")
			.append("\n")
			.append("3: Insertar nivel de poder en Super Guerrero")
			.append("\n")
			.append("4: Consultar")
			.append("\n")
			.append("5: Resetear Super Guerrero")
			.append("\n")
			.append("6: Eliminar Super Guerrero")
			.append("\n")
			.append("7: Eliminar Super Especie")
			.append("\n")
			.append("8: Ver instrucciones")
			.append("\n");

	public static StringBuilder getBienvenida() {
		return BIENVENIDA;
	}

	public static boolean isValidNumber(String eleccion) {
		String regex = "\\d";
		Pattern pattern = Pattern.compile(regex);

		if (pattern.matcher(eleccion).matches()) {
			return true;
		} else {
			return false;
		}

	}

}
