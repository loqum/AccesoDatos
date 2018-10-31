package com.rfm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionDataBase {

	private static final String URL = Literales.getUrl();
	private static final String USERNAME = Literales.getUser();
	private static final String PASS = Literales.getPass();
	private static final Logger LOGGER = Logger.getLogger(com.rfm.utils.ConnectionDataBase.class.getName());
	private static ConnectionDataBase instance = null;
	private Connection connection = null;

	private ConnectionDataBase() {

		try {

			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = DriverManager.getConnection(URL, USERNAME, PASS);
				LOGGER.debug(Literales.getConexionEstablecida());
			}

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(Literales.getConexionError(), e);

		}

	}

	public Connection getConnection() {
		return connection;
	}

	public static ConnectionDataBase getInstance() {
		if (instance == null) {
			instance = new ConnectionDataBase();
		}

		return instance;
	}

}
