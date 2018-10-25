package com.rfm.utils;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rfm.controller.Controller;
import com.rfm.controller.ControllerImpl;

public class Consola {

	private static StringBuilder builder = new StringBuilder();
	private static Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(com.rfm.utils.Consola.class.getName());

	public static void init() {
		Controller controller = new ControllerImpl();
		int eleccion = 0;

		do {
			System.out.println(bienvenida());
			scanner.nextInt(eleccion);

			switch (eleccion) {
			case 0:
				System.exit(0);
				LOGGER.debug("Saliendo del programa...");
				break;

			case 1:
				try {
					controller.createSuperEspecie();
				} catch (SQLException e) {
					LOGGER.error("No se ha podido crear la tabla", e);
				}

			case 2:
				try {
					controller.addSuperGuerrero();
				} catch (SQLException e) {
					LOGGER.error("No se ha podido insertar el registro", e);
				}

			case 3:
				try {
					controller.addPoder();
				} catch (SQLException e) {
					LOGGER.error("No se ha podido insertar el registro", e);
				}

			case 4:
				try {
					controller.readSuperGuerrero();
				} catch (SQLException e) {
					LOGGER.error("No se ha podido consultar el registro", e);
				}

			case 5:
				try {
					controller.resetSuperGuerrero();
				} catch (SQLException e) {
					LOGGER.error("No se ha podido resetear el registro", e);
				}

			case 6:
				try {
					controller.deleteSuperGuerrero();
				} catch (SQLException e) {
					LOGGER.error("No se ha podido eliminar el registro", e);
				}

			case 7:
				try {
					controller.deleteSuperEspecie();
				} catch (SQLException e) {
					LOGGER.error("No se ha podido eliminar el registro", e);
				}

			default:
				System.out.println("Entrada no válida");
				LOGGER.debug("Entrada inválida. Saliendo del programa...");
				break;
			}

		} while (eleccion >= 0);

	}
	
	public static String bienvenida() {
		builder
		.append("Bienvenido")
		.append("\n")
		.append("\nElija una opción:\n")
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
		
		return builder.toString();
	}

}
