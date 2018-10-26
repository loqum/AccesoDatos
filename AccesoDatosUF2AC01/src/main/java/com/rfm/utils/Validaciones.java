package com.rfm.utils;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;


public class Validaciones {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(com.rfm.utils.Validaciones.class.getName());
	private static final String AGUA = "agua";
	private static final String FUEGO = "fuego";
	private static final String VIENTO = "viento";	

	public static boolean isValidNumber(String eleccion) {
		String regex = "\\d";
		Pattern pattern = Pattern.compile(regex);

		if (pattern.matcher(eleccion).matches()) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isValidPower(String poder) {
		if (poder.equalsIgnoreCase(AGUA) || poder.equalsIgnoreCase(FUEGO) || poder.equalsIgnoreCase(VIENTO)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidLevel(int nivel) {
		if (nivel >= 1 && nivel <= 5) {
			return true;
		} else {
			return false;
		}
		
	}

}
