package com.rfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.rfm.dto.SuperGuerreroDto;
import com.rfm.utils.ConnectionDataBase;
import com.rfm.utils.Literales;
import com.rfm.view.Consola;

public class SuperGuerreroDaoImpl implements SuperGuerreroDao {

	private static final Logger LOGGER = Logger.getLogger(com.rfm.dao.SuperGuerreroDaoImpl.class.getName());

	@Override
	public void addSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException {
		PreparedStatement addSuperGuerrero = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			connection.setAutoCommit(false);

			addSuperGuerrero = connection.prepareStatement(Literales.getAddguerrero());
			addSuperGuerrero.setLong(1, Consola.getSuperGuerrero().getIdSuperEspecie());
			addSuperGuerrero.setString(2, Consola.getSuperGuerrero().getNombre());
			addSuperGuerrero.setString(3, Consola.getSuperGuerrero().getDescripcion());
			addSuperGuerrero.setString(4, Consola.getSuperGuerrero().getTipoPoder());
			addSuperGuerrero.setInt(5, Consola.getSuperGuerrero().getNivelPoder());

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
