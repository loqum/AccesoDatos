package com.rfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.rfm.dto.SuperEspecieDto;
import com.rfm.utils.ConnectionDataBase;
import com.rfm.utils.Literales;
import com.rfm.view.Consola;

public class SuperEspecieDaoImpl implements SuperEspecieDao {

	private static final Logger LOGGER = Logger.getLogger(com.rfm.dao.SuperEspecieDaoImpl.class.getName());

	@Override
	public void addSuperEspecie(SuperEspecieDto superEspecie) throws SQLException {

		PreparedStatement addSuperEspecie = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {
			connection.setAutoCommit(false);
			addSuperEspecie = connection.prepareStatement(Literales.getAddsuperespecie());
			addSuperEspecie.setString(1, Consola.getSuperEspecie().getNombre());
			connection.commit();

			if (addSuperEspecie.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
				System.out.println(Literales.getRegistroExitoInsert());
			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorInsert(), e);
			System.out.println(Literales.getRegistroErrorInsert());

		} finally {

			if (addSuperEspecie != null) {
				addSuperEspecie.close();
			}

		}

		System.out.println(Literales.getBienvenidaPrograma());

	}

	@Override
	public void deleteSuperEspecie(SuperEspecieDto superEspecie) throws SQLException {

		Statement sentence = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getDeleteespecie()) > 0) {
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
