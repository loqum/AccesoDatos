package com.rfm.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.rfm.utils.Consola;
import com.rfm.utils.DataBase;
import com.rfm.utils.Literales;

public class ControllerImpl implements Controller {

	private static final Logger LOGGER = Logger.getLogger(com.rfm.controller.ControllerImpl.class.getName());

	@Override
	public void addSuperEspecie() throws SQLException {
		Connection connection = null;
		PreparedStatement addSuperEspecie = null;

		try {
			connection = DataBase.getInstance().getConnection();
			connection.setAutoCommit(false);
			addSuperEspecie = connection.prepareStatement(Literales.getAddsuperespecie());
			addSuperEspecie.setString(1, Consola.superEspecie.getNombre());
			connection.commit();

			if (addSuperEspecie.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
				System.out.println(Literales.getRegistroExitoInsert());
			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			if (connection != null) {
				try {
					LOGGER.error(Literales.getRegistroErrorInsert(), e);
					System.out.println(Literales.getRegistroErrorInsert());
					connection.rollback();
				} catch (SQLException excep) {
					LOGGER.error(excep);
				} 
			}
			
		} finally {
			
			if (addSuperEspecie != null) {
				addSuperEspecie.close();
			}
			
			if (connection != null) {
				connection.close();
			}
			
			connection.setAutoCommit(true);
		}
		
		System.out.println(Literales.getBienvenidaPrograma());

	}

	@Override
	public void addSuperGuerrero() throws SQLException {
		Connection connection = null;
		PreparedStatement addSuperGuerrero = null;
		
		try {
			connection = DataBase.getInstance().getConnection();
			connection.setAutoCommit(false);
			
			addSuperGuerrero = connection.prepareStatement(Literales.getAddguerrero());
			addSuperGuerrero.setLong(1, Consola.superGuerrero.getIdSuperEspecie());
			addSuperGuerrero.setString(2, Consola.superGuerrero.getNombre());
			addSuperGuerrero.setString(3, Consola.superGuerrero.getDescripcion());
			addSuperGuerrero.setString(4, Consola.superGuerrero.getTipoPoder());
			addSuperGuerrero.setInt(5, Consola.superGuerrero.getNivelPoder());
			
			connection.commit();

			if (addSuperGuerrero.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
				System.out.println(Literales.getRegistroExitoInsert());
			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			if (connection != null) {
				try {
					LOGGER.error(Literales.getRegistroErrorInsert(), e);
					System.out.println(Literales.getRegistroErrorInsert());
					connection.rollback();
				} catch (SQLException excep) {
					LOGGER.error(excep);
				} 
			}
			
		} finally {
			if (addSuperGuerrero != null) {
				addSuperGuerrero.close();
			}
			
			if (connection != null) {
				connection.close();
			}
			
			connection.setAutoCommit(true);
		}

	}

	@Override
	public void addPoder() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getAddpoder()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorInsert(), e);
			System.out.println(Literales.getRegistroErrorInsert());
		}

	}

	@Override
	public void readSuperGuerrero() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			sentence.executeQuery(Literales.getRead());
			LOGGER.debug(sentence.toString());

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorSelect(), e);
			System.out.println(Literales.getRegistroErrorSelect());
		}

	}

	@Override
	public void resetSuperGuerrero() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getReset()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoReset());
			} else {
				LOGGER.debug(Literales.getRegistroErrorReset());
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorReset(), e);
			System.out.println(Literales.getRegistroErrorReset());
		}

	}

	@Override
	public void deleteSuperGuerrero() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getDeleteguerrero()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoDelete());
			} else {
				LOGGER.debug(Literales.getRegistroErrorDelete());
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorDelete(), e);
			System.out.println(Literales.getRegistroErrorDelete());
		}

	}

	@Override
	public void deleteSuperEspecie() {
		Connection connection;
		try {
			connection = DataBase.getInstance().getConnection();
			Statement sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getDeleteespecie()) > 0) {
				LOGGER.debug(Literales.getRegistroExitoDelete());
			} else {
				LOGGER.debug(Literales.getRegistroErrorDelete());
			}

			sentence.close();
			connection.close();

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorDelete(), e);
			System.out.println(Literales.getRegistroErrorDelete());
		}

	}

}
