package com.rfm.utils;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rfm.controller.Controller;
import com.rfm.controller.ControllerImpl;
import com.rfm.modelos.SuperEspecie;
import com.rfm.modelos.SuperGuerrero;

public class Consola {

	private static Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(com.rfm.utils.Consola.class.getName());
	public static SuperEspecie superEspecie = new SuperEspecie();
	public static SuperGuerrero superGuerrero = new SuperGuerrero();
	private static String poder = null;
	private static String nivel = null;

	public static void init() throws SQLException {
		Controller controller = new ControllerImpl();
		String eleccion = null;
		boolean isActive = true;

		System.out.println(Literales.getBienvenidaPrograma());

		while (isActive) {
			eleccion = scanner.nextLine();

			if (Validaciones.isValidNumber(eleccion)) {

				switch (Integer.parseInt(eleccion)) {

				case 0:
					LOGGER.debug(Literales.getSalidaPrograma());
					System.out.println(Literales.getSalidaPrograma());
					System.exit(0);
					break;

				case 1:
					System.out.println(Literales.getIntroduceNombreEspecie());
					superEspecie.setNombre(scanner.nextLine());
					controller.addSuperEspecie();
					break;

				case 2:
					System.out.println(Literales.getIntroduceNombreGuerrero());
					superGuerrero.setNombre(scanner.nextLine());
					System.out.println(Literales.getIntroduceDescripcionGuerrero().concat(superGuerrero.getNombre()));
					superGuerrero.setDescripcion(scanner.nextLine());
					System.out.println(Literales.getIntroduceTipopoderGuerrero().concat(superGuerrero.getNombre()));

					poder = scanner.nextLine();

					while (!Validaciones.isValidPower(poder)) {
						System.out.println(Literales.getIntroducePoderError());
						poder = scanner.nextLine();
					}

					superGuerrero.setTipoPoder(poder);

					System.out.println(Literales.getIntroduceNivelpoderGuerrero().concat(superGuerrero.getNombre()));
					
					nivel = scanner.nextLine();
					
					while (!Validaciones.isValidNumber(nivel) || !Validaciones.isValidLevel(Integer.parseInt(nivel))) {
						System.out.println(Literales.getEntradaInvalida());
						nivel = scanner.nextLine();
					}
					
					superGuerrero.setNivelPoder(Integer.parseInt(nivel));
					
					controller.addSuperGuerrero();
					break;

				case 3:
					try {
						controller.addPoder();
					} catch (SQLException e) {
						LOGGER.error(Literales.getRegistroErrorInsert(), e);
						System.out.println(Literales.getRegistroErrorInsert());
					}

					break;

				case 4:
					try {
						controller.readSuperGuerrero();
					} catch (SQLException e) {
						LOGGER.error(Literales.getRegistroErrorSelect(), e);
						System.out.println(Literales.getRegistroErrorSelect());
					}

					break;

				case 5:
					try {
						controller.resetSuperGuerrero();
					} catch (SQLException e) {
						LOGGER.error(Literales.getRegistroErrorReset(), e);
						System.out.println(Literales.getRegistroErrorReset());
					}

					break;

				case 6:
					try {
						controller.deleteSuperGuerrero();
					} catch (SQLException e) {
						LOGGER.error(Literales.getRegistroErrorDelete(), e);
						System.out.println(Literales.getRegistroErrorDelete());
					}

					break;

				case 7:
					try {
						controller.deleteSuperEspecie();
					} catch (SQLException e) {
						LOGGER.error(Literales.getRegistroErrorDelete(), e);
						System.out.println(Literales.getRegistroErrorDelete());
					}

					break;

				case 8:
					System.out.println(Literales.getBienvenidaPrograma());
					break;

				default:
					LOGGER.debug(Literales.getEntradaInvalida());
					System.out.println(Literales.getEntradaInvalida());
					break;
				}
			} else {
				System.out.println(Literales.getEntradaInvalida());
				LOGGER.debug(Literales.getEntradaInvalida());
			}

		}

	}

}
