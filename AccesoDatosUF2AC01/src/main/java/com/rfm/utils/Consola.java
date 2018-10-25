package com.rfm.utils;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rfm.controller.Controller;
import com.rfm.controller.ControllerImpl;

public class Consola {

	private static Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(com.rfm.utils.Consola.class.getName());

	public static void init() {
		Controller controller = new ControllerImpl();
		String eleccion = null;
		boolean isActive = true;

		while (isActive) {
			System.out.println(Util.getBienvenida());
			eleccion = scanner.nextLine();

			if (Util.isValidNumber(eleccion)) {

				switch (Integer.parseInt(eleccion)) {
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
					
					break;

				case 2:
					try {
						controller.addSuperGuerrero();
					} catch (SQLException e) {
						LOGGER.error("No se ha podido insertar el registro", e);
					}
					
					break;

				case 3:
					try {
						controller.addPoder();
					} catch (SQLException e) {
						LOGGER.error("No se ha podido insertar el registro", e);
					}
					
					break;

				case 4:
					try {
						controller.readSuperGuerrero();
					} catch (SQLException e) {
						LOGGER.error("No se ha podido consultar el registro", e);
					}
					
					break;

				case 5:
					try {
						controller.resetSuperGuerrero();
					} catch (SQLException e) {
						LOGGER.error("No se ha podido resetear el registro", e);
					}
					
					break;

				case 6:
					try {
						controller.deleteSuperGuerrero();
					} catch (SQLException e) {
						LOGGER.error("No se ha podido eliminar el registro", e);
					}
					
					break;

				case 7:
					try {
						controller.deleteSuperEspecie();
					} catch (SQLException e) {
						LOGGER.error("No se ha podido eliminar el registro", e);
					}
					
					break;

				default:
					LOGGER.debug("Entrada invalida...");
					break;
				}
			} else {
				System.out.println("Debe introducir un valor numerico que se corresponda con las intrucciones.\n");
				LOGGER.debug("Ha introducido un valor no valido");
			}

		}

	}

}
