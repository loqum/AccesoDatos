package com.rfm.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.rfm.utils.DataBase;

public class ControllerImpl implements Controller {

	private static final Logger LOGGER = Logger.getLogger(com.rfm.controller.ControllerImpl.class.getName());
	private static final String CREATE = "";
	private static final String ADDGUERRERO = "";
	private static final String ADDPODER = "";
	private static final String READ = "";
	private static final String RESET = "";
	private static final String DELETEGUERRERO = "";
	private static final String DELETEESPECIE = "";

	@Override
	public void createSuperEspecie() {
		Connection connection;

		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(CREATE) > 0) {
				LOGGER.debug("La tabla se ha creado satisfactoriamente");
			} else {
				LOGGER.debug("La tabla no se ha podido crear");
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("No se ha podido crear la tabla SuperEspecie", e);
			System.out.println("No se ha podido crear la tabla SuperEspecie");
		}

	}

	@Override
	public void addSuperGuerrero() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(ADDGUERRERO) > 0) {
				LOGGER.debug("El registro se ha insertado satisfactoriamente");
			} else {
				LOGGER.debug("El registro no se ha podido insertar");
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("No se ha podido insertar el registro", e);
			System.out.println("No se ha podido insertar el registro");
		}

	}

	@Override
	public void addPoder() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(ADDPODER) > 0) {
				LOGGER.debug("El registro se ha insertado satisfactoriamente");
			} else {
				LOGGER.debug("El registro no se ha podido insertar");
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("No se ha podido insertar el registro", e);
			System.out.println("No se ha podido insertar el registro");
		}

	}

	@Override
	public void readSuperGuerrero() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			sentence.executeQuery(READ);
			LOGGER.debug(sentence.toString());

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("No se ha podido acceder al registro", e);
			System.out.println("No se ha podido acceder al registro");
		}

	}

	@Override
	public void resetSuperGuerrero() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(RESET) > 0) {
				LOGGER.debug("El registro se ha reseteado satisfactoriamente");
			} else {
				LOGGER.debug("El registro no se ha podido resetear");
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("No se ha podido resetear el registro", e);
			System.out.println("No se ha podido resetear el registro");
		}

	}

	@Override
	public void deleteSuperGuerrero() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(DELETEGUERRERO) > 0) {
				LOGGER.debug("El registro se ha borrado satisfactoriamente");
			} else {
				LOGGER.debug("El registro no se ha podido borrar");
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("No se ha podido borrar el registro", e);
			System.out.println("No se ha podido borrar el registro");
		}

	}

	@Override
	public void deleteSuperEspecie() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(DELETEESPECIE) > 0) {
				LOGGER.debug("El registro se ha borrado satisfactoriamente");
			} else {
				LOGGER.debug("El registro no se ha podido borrar");
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("No se ha podido borrar el registro", e);
			System.out.println("No se ha podido borrar el registro");
		}

	}

}
