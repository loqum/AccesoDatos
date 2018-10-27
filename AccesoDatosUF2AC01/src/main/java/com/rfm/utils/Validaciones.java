package com.rfm.utils;

import java.util.regex.Pattern;

public class Validaciones {

	private Validaciones() {
		throw new IllegalStateException("Utility class");
	}

	private static final String AGUA = "agua";
	private static final String FUEGO = "fuego";
	private static final String VIENTO = "viento";

	public static boolean isValidNumber(String eleccion) {
		String regex = "\\d";
		Pattern pattern = Pattern.compile(regex);
		boolean validNumber;

		validNumber = (pattern.matcher(eleccion).matches());
		return validNumber;

	}

	public static boolean isValidPower(String poder) {
		boolean validPower;
		validPower = (poder.equalsIgnoreCase(AGUA) || poder.equalsIgnoreCase(FUEGO) || poder.equalsIgnoreCase(VIENTO));
		return validPower;
	}

	public static boolean isValidLevel(int nivel) {
		boolean validLevel;
		validLevel = (nivel >= 1 && nivel <= 5);
		return validLevel;
	}

}
