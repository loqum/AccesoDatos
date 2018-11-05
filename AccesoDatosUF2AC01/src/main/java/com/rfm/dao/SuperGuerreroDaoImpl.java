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
	private static List<String> listaIdSuperGuerreros = new ArrayList<>();

	@Override
	public synchronized void createSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {

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
				idsuperespecie = resultSet.getLong(Literales.getIdSuperespecie());
				nombre = resultSet.getString(Literales.getNombre());

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
	public synchronized void updatePoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		Connection connection = null;
		long idSuperGuerrero = 0;
		long idSuperEspecie = 0;
		int nivelPoder = 0;

		String nombre = null;
		String descripcion = null;
		String tipoPoder = null;
		String output = null;
		String id = null;
		String nuevoPoder = null;
		int nuevoNivelPoder = 0;

		try {
			connection = ConnectionDataBase.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Literales.getSelectSuperGuerrero());

			System.out.println(Literales.getIntroduceIdUpdateSuperguerrero());

			while (resultSet.next()) {
				idSuperGuerrero = resultSet.getLong(Literales.getIdSuperguerrero());
				idSuperEspecie = resultSet.getLong(Literales.getIdSuperespecie());
				nombre = resultSet.getString(Literales.getNombre());
				descripcion = resultSet.getString(Literales.getDescripcionSuperguerrero());
				tipoPoder = resultSet.getString(Literales.getTipoPoderSuperguerrero());
				nivelPoder = resultSet.getInt(Literales.getNivelPoderSuperguerrero());

				output = Literales.getOutputFormatSuperGuerrero();
				listaIdSuperGuerreros.add(String.valueOf(idSuperGuerrero));

				if (!listaIdSuperGuerreros.isEmpty()) {
					System.out.println(String.format(output, idSuperGuerrero, idSuperEspecie, nombre, descripcion,
							tipoPoder, nivelPoder));

				} else {
					System.out.println(Literales.getErrorNoSuperGuerrero());
				}
			}

			id = scanner.nextLine();

			while (!Validaciones.isValidNumber(String.valueOf(id))
					|| !Validaciones.isValidId(String.valueOf(id), listaIdSuperGuerreros)) {
				System.out.println(Literales.getIntroduceIdError());
				id = scanner.nextLine();
			}

			System.out.println(Literales.getIntroduceTipopoderGuerrero());

			nuevoPoder = scanner.nextLine();

			while (!Validaciones.isValidPower(nuevoPoder)) {
				System.out.println(Literales.getIntroducePoderError());
				nuevoPoder = scanner.nextLine();
			}

			System.out.println(Literales.getIntroduceNivelpoderGuerrero());

			nuevoNivelPoder = scanner.nextInt();

			while (!Validaciones.isValidNumber(String.valueOf(nuevoNivelPoder))
					|| !Validaciones.isValidLevel(nuevoNivelPoder)) {
				System.out.println(Literales.getEntradaInvalida());
			}

			preparedStatement = connection.prepareStatement(Literales.getUpdatePoder());
			preparedStatement.setString(1, nuevoPoder);
			preparedStatement.setInt(2, nuevoNivelPoder);
			preparedStatement.setLong(3, Long.parseLong(id));

			if (preparedStatement.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
				System.out.println(Literales.getRegistroExitoInsert());

			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
				System.out.println(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorSelect(), e);
			System.out.println(Literales.getRegistroErrorSelect());
		}

	}

	@Override
	public synchronized void readSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		Connection connection = null;
		long idSuperGuerrero = 0;
		long idSuperEspecie = 0;
		String nombre = null;
		String descripcion = null;
		String tipoPoder = null;
		String output = null;
		int nivelPoder = 0;

		try {
			connection = ConnectionDataBase.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Literales.getSelectSuperGuerrero());

			while (resultSet.next()) {
				idSuperGuerrero = resultSet.getLong(Literales.getIdSuperguerrero());
				idSuperEspecie = resultSet.getLong(Literales.getIdSuperespecie());
				nombre = resultSet.getString(Literales.getNombre());
				descripcion = resultSet.getString(Literales.getDescripcionSuperguerrero());
				tipoPoder = resultSet.getString(Literales.getTipoPoderSuperguerrero());
				nivelPoder = resultSet.getInt(Literales.getNivelPoderSuperguerrero());

				output = Literales.getOutputFormatSuperGuerrero();
				listaIdSuperGuerreros.add(String.valueOf(idSuperGuerrero));

				if (!listaIdSuperGuerreros.isEmpty()) {
					System.out.println(String.format(output, idSuperGuerrero, idSuperEspecie, nombre, descripcion,
							tipoPoder, nivelPoder));
				} else {
					System.out.println(Literales.getErrorNoSuperGuerrero());
				}
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorSelect(), e);
			System.out.println(Literales.getRegistroErrorSelect());

		}

	}

	@Override
	public synchronized void resetPoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		Connection connection = null;
		long idSuperGuerrero = 0;
		long idSuperEspecie = 0;
		int nivelPoder = 0;
		String nombre = null;
		String descripcion = null;
		String tipoPoder = null;
		String output = null;
		String id = null;

		try {
			connection = ConnectionDataBase.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Literales.getSelectSuperGuerrero());

			System.out.println(Literales.getIntroduceIdResetSuperguerrero());

			while (resultSet.next()) {
				idSuperGuerrero = resultSet.getLong(Literales.getIdSuperguerrero());
				idSuperEspecie = resultSet.getLong(Literales.getIdSuperespecie());
				nombre = resultSet.getString(Literales.getNombre());
				descripcion = resultSet.getString(Literales.getDescripcionSuperguerrero());
				tipoPoder = resultSet.getString(Literales.getTipoPoderSuperguerrero());
				nivelPoder = resultSet.getInt(Literales.getNivelPoderSuperguerrero());

				output = Literales.getOutputFormatSuperGuerrero();
				listaIdSuperGuerreros.add(String.valueOf(idSuperGuerrero));

				if (!listaIdSuperGuerreros.isEmpty()) {
					System.out.println(String.format(output, idSuperGuerrero, idSuperEspecie, nombre, descripcion,
							tipoPoder, nivelPoder));

				} else {
					System.out.println(Literales.getErrorNoSuperGuerrero());
				}
			}

			id = scanner.nextLine();

			while (!Validaciones.isValidNumber(String.valueOf(id))
					|| !Validaciones.isValidId(String.valueOf(id), listaIdSuperGuerreros)) {
				System.out.println(Literales.getIntroduceIdError());
				id = scanner.nextLine();
			}

			preparedStatement = connection.prepareStatement(Literales.getResetPoderSuperGuerrero());
			preparedStatement.setLong(1, Long.parseLong(id));

			if (preparedStatement.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoReset());
				System.out.println(Literales.getRegistroExitoReset());

			} else {
				LOGGER.debug(Literales.getRegistroErrorReset());
				System.out.println(Literales.getRegistroErrorReset());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorSelect(), e);
			System.out.println(Literales.getRegistroErrorSelect());
		}

	}

	@Override
	public synchronized void deleteSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		Connection connection = null;
		long idSuperGuerrero = 0;
		long idSuperEspecie = 0;
		int nivelPoder = 0;
		String nombre = null;
		String descripcion = null;
		String tipoPoder = null;
		String output = null;
		String id = null;

		try {
			connection = ConnectionDataBase.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Literales.getSelectSuperGuerrero());

			System.out.println(Literales.getIntroduceIdSuperguerrero());

			while (resultSet.next()) {

				idSuperGuerrero = resultSet.getLong(Literales.getIdSuperguerrero());
				idSuperEspecie = resultSet.getLong(Literales.getIdSuperespecie());
				nombre = resultSet.getString(Literales.getNombre());
				descripcion = resultSet.getString(Literales.getDescripcionSuperguerrero());
				tipoPoder = resultSet.getString(Literales.getTipoPoderSuperguerrero());
				nivelPoder = resultSet.getInt(Literales.getNivelPoderSuperguerrero());

				output = Literales.getOutputFormatSuperGuerrero();
				listaIdSuperGuerreros.add(String.valueOf(idSuperGuerrero));
				if (!listaIdSuperGuerreros.isEmpty()) {
					System.out.println(String.format(output, idSuperGuerrero, idSuperEspecie, nombre, descripcion,
							tipoPoder, nivelPoder));
				}
			}

			id = scanner.nextLine();

			while (!Validaciones.isValidNumber(String.valueOf(id))
					|| !Validaciones.isValidId(String.valueOf(id), listaIdSuperGuerreros)) {
				System.out.println(Literales.getIntroduceIdError());
				id = scanner.nextLine();
			}

			preparedStatement = connection.prepareStatement(Literales.getDeleteSuperGuerrero());
			preparedStatement.setLong(1, Long.parseLong(id));

			if (preparedStatement.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoDelete());
				System.out.println(Literales.getRegistroExitoDelete());

			} else {
				LOGGER.debug(Literales.getRegistroErrorDelete());
				System.out.println(Literales.getRegistroErrorDelete());
			}

		} catch (SQLException e) {

			LOGGER.error(Literales.getRegistroErrorDelete(), e);
			System.out.println(Literales.getRegistroErrorDelete());
		}
	}
}
