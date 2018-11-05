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

		do {

			eleccion = scanner.nextLine();

			if (Validaciones.isValidNumber(eleccion)) {

				switch (Integer.parseInt(eleccion)) {

				case 0:
					LOGGER.debug(Literales.getSalidaPrograma());
					System.out.println(Literales.getSalidaPrograma());
					break;

				case 1:
					superEspecieDao.createSuperEspecie(superEspecie);
					break;

				case 2:
					superGuerreroDao.createSuperGuerrero(superGuerrero);
					break;

				case 3:
					superEspecieDao.readSuperEspecie(superEspecie);
					break;

				case 4:
					superGuerreroDao.readSuperGuerrero(superGuerrero);
					break;

				case 5:
					superGuerreroDao.updatePoderSuperGuerrero(superGuerrero);
					break;

				case 6:
					superGuerreroDao.resetPoderSuperGuerrero(superGuerrero);
					break;

				case 7:
					superGuerreroDao.deleteSuperGuerrero(superGuerrero);
					break;

				case 8:
					superEspecieDao.deleteSuperEspecie(superEspecie);
					break;

				case 9:
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

		} while (!eleccion.equals("0"));
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
