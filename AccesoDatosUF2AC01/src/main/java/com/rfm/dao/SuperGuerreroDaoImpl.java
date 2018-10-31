package com.rfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	@Override
	public synchronized void addSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {

		String poder = null;
		String nivel = null;
		long idsuperespecie = 0;
		List<String> listaIdSuperEspecie = new ArrayList<>();
		String nombre = null;
		String id = null;
		Connection connection = null;

		System.out.println(Literales.getIntroduceTipoEspecie());

		try {
			connection = ConnectionDataBase.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Literales.getSelectSuperespecie());

			while (resultSet.next()) {
				idsuperespecie = resultSet.getLong("idsuperespecie");
				nombre = resultSet.getString("nombre");

				String output = "Super Especie #%d: %s";
				System.out.println(String.format(output, idsuperespecie, nombre));
				listaIdSuperEspecie.add(String.valueOf(idsuperespecie));
			}

			id = scanner.nextLine();

			while (!Validaciones.isValidNumber(String.valueOf(id))
					|| !Validaciones.isValidId(String.valueOf(id), listaIdSuperEspecie)) {
				System.out.println(Literales.getIntroduceIdError());
				id = scanner.nextLine();
			}

			superGuerrero.setIdSuperEspecie(Long.parseLong(id));

			System.out.println(Literales.getIntroduceNombreGuerrero());
			superGuerrero.setNombre(scanner.nextLine());

			System.out.println(Literales.getIntroduceDescripcionGuerrero().concat(superGuerrero.getNombre()));
			superGuerrero.setDescripcion(scanner.nextLine());

			System.out.println(Literales.getIntroduceTipopoderGuerrero().concat(superGuerrero.getNombre()));
			poder = scanner.nextLine();

			while (!Validaciones.isValidPower(poder)) {
				System.out.println(Literales.getIntroducePoderError());
				poder = scanner.next();
			}

			superGuerrero.setTipoPoder(poder);

			System.out.println(Literales.getIntroduceNivelpoderGuerrero().concat(superGuerrero.getNombre()));
			nivel = scanner.nextLine();

			while (!Validaciones.isValidNumber(nivel) || !Validaciones.isValidLevel(Integer.parseInt(nivel))) {
				System.out.println(Literales.getEntradaInvalida());
				nivel = scanner.nextLine();
			}

			superGuerrero.setNivelPoder(Integer.parseInt(nivel));

			preparedStatement = connection.prepareStatement(Literales.getInsertSuperGuerrero());

			preparedStatement.setLong(1, Consola.getSuperGuerrero().getIdSuperEspecie());
			preparedStatement.setString(2, Consola.getSuperGuerrero().getNombre());
			preparedStatement.setString(3, Consola.getSuperGuerrero().getDescripcion());
			preparedStatement.setString(4, Consola.getSuperGuerrero().getTipoPoder());
			preparedStatement.setInt(5, Consola.getSuperGuerrero().getNivelPoder());

			if (preparedStatement.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
				System.out.println(Literales.getRegistroExitoInsert());

			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorInsert(), e);
			System.out.println(Literales.getRegistroErrorInsert());

		}

	}

	@Override
	public synchronized void addPoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			statement = connection.createStatement();

			if (statement.executeUpdate(Literales.getUpdatePoder()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorInsert(), e);
			System.out.println(Literales.getRegistroErrorInsert());

		} finally {
			try {

				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

	@Override
	public synchronized void readSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			statement = connection.createStatement();

			statement.executeQuery(Literales.getSelectSuperGuerrero());
			LOGGER.debug(statement.toString());

			statement.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorSelect(), e);
			System.out.println(Literales.getRegistroErrorSelect());

		} finally {
			try {

				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

	@Override
	public synchronized void resetSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			statement = connection.createStatement();

			if (statement.executeUpdate(Literales.getReserSuperGuerrero()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoReset());
			} else {
				LOGGER.debug(Literales.getRegistroErrorReset());
			}

			statement.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorReset(), e);
			System.out.println(Literales.getRegistroErrorReset());
		} finally {

			try {

				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

	@Override
	public synchronized void deleteSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			statement = connection.createStatement();

			if (statement.executeUpdate(Literales.getDeleteSuperGuerrero()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoDelete());
			} else {
				LOGGER.debug(Literales.getRegistroErrorDelete());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorDelete(), e);
			System.out.println(Literales.getRegistroErrorDelete());

		} finally {

			try {

				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				LOGGER.error(Literales.getRegistroErrorReset(), e);
			}
		}

	}

}
