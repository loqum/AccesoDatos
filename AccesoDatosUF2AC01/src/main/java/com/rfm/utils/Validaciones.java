package com.rfm.utils;

import java.util.List;
import java.util.regex.Pattern;

public class Validaciones {

	private Validaciones() {
		throw new IllegalStateException("Utility class");
	}

	private static final String AGUA = "agua";
	private static final String FUEGO = "fuego";
	private static final String VIENTO = "viento";

	public static boolean isValidNumber(String eleccion) {
		String regex = "\\d+";
		Pattern pattern = Pattern.compile(regex);
		boolean validNumber;

		validNumber = (pattern.matcher(eleccion.trim()).matches());
		return validNumber;

	}

	public static boolean isValidPower(String poder) {
		boolean validPower;
		validPower = (poder.trim().equalsIgnoreCase(AGUA) || poder.trim().equalsIgnoreCase(FUEGO)
				|| poder.trim().equalsIgnoreCase(VIENTO));
		return validPower;
	}

	public static boolean isValidLevel(int nivel) {
		boolean validLevel;
		validLevel = (nivel >= 1 && nivel <= 5);
		return validLevel;
	}

	public static boolean isValidId(String primerId, List<String> segundoId) {
		for (String resultadosSegundoId : segundoId) {
			if (primerId.trim().equals(resultadosSegundoId)) {
				return true;
			}
		}
		return false;
	}

}
