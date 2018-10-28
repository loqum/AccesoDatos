package com.rfm.view;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rfm.dao.SuperEspecieDaoImpl;
import com.rfm.dao.SuperGuerreroDaoImpl;
import com.rfm.dto.SuperEspecieDto;
import com.rfm.dto.SuperGuerreroDto;
import com.rfm.utils.Literales;
import com.rfm.utils.Validaciones;

public class Consola {

	private Consola() {
		throw new IllegalStateException("Utility class");
	}

	private static Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(com.rfm.view.Consola.class.getName());
	private static SuperEspecieDto superEspecie = new SuperEspecieDto();
	private static SuperGuerreroDto superGuerrero = new SuperGuerreroDto();
	private static SuperGuerreroDaoImpl superGuerreroDao = new SuperGuerreroDaoImpl();
	private static SuperEspecieDaoImpl superEspecieDao = new SuperEspecieDaoImpl();
	private static String eleccion = null;

	public static void init() throws SQLException {

		System.out.println(Literales.getBienvenidaPrograma());

		while (true) {

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
					superEspecieDao.addSuperEspecie(superEspecie);
					break;

				case 2:
					String poder = null;
					String nivel = null;

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

					superGuerreroDao.addSuperGuerrero(superGuerrero);
					break;

				case 3:

					superGuerreroDao.addPoderSuperGuerrero(superGuerrero);
					break;

				case 4:

					superGuerreroDao.readSuperGuerrero(superGuerrero);
					break;

				case 5:

					superGuerreroDao.resetSuperGuerrero(superGuerrero);
					break;

				case 6:

					superGuerreroDao.deleteSuperGuerrero(superGuerrero);
					break;

				case 7:
					superEspecieDao.deleteSuperEspecie(superEspecie);

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

	public static SuperEspecieDto getSuperEspecie() {
		return superEspecie;
	}

	public static SuperGuerreroDto getSuperGuerrero() {
		return superGuerrero;
	}

	public static String getEleccion() {
		return eleccion;
	}

}
