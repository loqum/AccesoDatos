package com.rfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rfm.dto.SuperEspecieDto;
import com.rfm.utils.ConnectionDataBase;
import com.rfm.utils.Literales;
import com.rfm.view.Consola;

public class SuperEspecieDaoImpl implements SuperEspecieDao {

	private static Scanner scanner = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(com.rfm.dao.SuperEspecieDaoImpl.class.getName());
	private static PreparedStatement preparedStatement = null;

	@Override
	public synchronized void addSuperEspecie(SuperEspecieDto superEspecie) throws SQLException {
		Connection connection = null;
		System.out.println(Literales.getIntroduceNombreEspecie());
		superEspecie.setNombre(scanner.nextLine());

		try {
			connection = ConnectionDataBase.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(Literales.getInsertSuperEspecie());
			preparedStatement.setString(1, Consola.getSuperEspecie().getNombre());

			if (preparedStatement.executeUpdate() > 0) {
				LOGGER.debug(Literales.getRegistroExitoInsert());
				System.out.println(Literales.getRegistroExitoInsert());

			} else {
				LOGGER.debug(Literales.getRegistroErrorInsert());
			}

		} catch (SQLException e) {
			LOGGER.error(Literales.getRegistroErrorInsert(), e);
			System.out.println(Literales.getRegistroErrorInsert());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

		}

		System.out.println(Literales.getBienvenidaPrograma());

	}

	@Override
	public synchronized void deleteSuperEspecie(SuperEspecieDto superEspecie) throws SQLException {

		Statement sentence = null;

		try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {

			sentence = connection.createStatement();

			if (sentence.executeUpdate(Literales.getDeleteSuperEspecie()) > 0) {
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
