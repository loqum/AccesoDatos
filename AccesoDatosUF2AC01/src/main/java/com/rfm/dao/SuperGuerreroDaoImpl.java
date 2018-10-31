package com.rfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rfm.dto.SuperGuerreroDto;
import com.rfm.utils.ConnectionDataBase;
import com.rfm.utils.Literales;
import com.rfm.utils.Validaciones;
import com.rfm.view.Consola;

public class SuperGuerreroDaoImpl implements SuperGuerreroDao {

	private static Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(com.rfm.dao.SuperGuerreroDaoImpl.class.getName());

	@Override
	public void addSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		PreparedStatement addSuperGuerrero = null;
//		Statement sentence = null;
//		ResultSet resultSet = null;
		Connection connection = null;

		String poder = null;
		String nivel = null;

		// TODO
//		System.out.println(Literales.getIntroduceTipoEspecie());
//		try {
//			connection = ConnectionDataBase.getInstance().getConnection();
//			resultSet = sentence.executeQuery(Literales.getSelectSuperespecie()); 
//			while (resultSet.next()) {
//				String line = resultSet.getString(columnIndex) 
//			}
//			
//		}

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

		try {

			connection = ConnectionDataBase.getInstance().getConnection();

			connection.setAutoCommit(false);

			addSuperGuerrero = connection.prepareStatement(Literales.getAddguerrero());
			addSuperGuerrero.setLong(1, 1);
			addSuperGuerrero.setLong(2, 1);
			addSuperGuerrero.setString(3, Consola.getSuperGuerrero().getNombre());
			addSuperGuerrero.setString(4, Consola.getSuperGuerrero().getDescripcion());
			addSuperGuerrero.setString(5, Consola.getSuperGuerrero().getTipoPoder());
			addSuperGuerrero.setInt(6, Consola.getSuperGuerrero().getNivelPoder());

			connection.commit();

			if (addSuperGuerrero.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
				System.out.println(Literales.getRegistroExitoInsert());

			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorInsert(), e);
			System.out.println(Literales.getRegistroErrorInsert());

		} finally {

			if (addSuperGuerrero != null) {
				addSuperGuerrero.close();
			}

		}

	}

	@Override
	public void addPoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {

		Statement sentence = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getAddpoder()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorInsert(), e);
			System.out.println(Literales.getRegistroErrorInsert());

		} finally {
			try {

				if (sentence != null) {
					sentence.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

	@Override
	public void readSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		Statement sentence = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			sentence = connection.createStatement();

			sentence.executeQuery(Literales.getRead());
			LOGGER.debug(sentence.toString());

			sentence.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorSelect(), e);
			System.out.println(Literales.getRegistroErrorSelect());

		} finally {
			try {

				if (sentence != null) {
					sentence.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

	@Override
	public void resetSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		Statement sentence = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getReset()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoReset());
			} else {
				LOGGER.debug(Literales.getRegistroErrorReset());
			}

			sentence.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorReset(), e);
			System.out.println(Literales.getRegistroErrorReset());
		} finally {

			try {

				if (sentence != null) {
					sentence.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

	@Override
	public void deleteSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		Statement sentence = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getDeleteguerrero()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoDelete());
			} else {
				LOGGER.debug(Literales.getRegistroErrorDelete());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorDelete(), e);
			System.out.println(Literales.getRegistroErrorDelete());

		} finally {

			try {

				if (sentence != null) {
					sentence.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

}
