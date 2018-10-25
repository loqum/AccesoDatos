package com.rfm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DataBase {

	private static final String URL = "jdbc:mysql://localhost:3306/accesodatos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "fihoca";
	private static final Logger LOGGER = Logger.getLogger(com.rfm.utils.DataBase.class.getName());
	private static DataBase instance = null;
	private Connection connection = null;

	private DataBase() {

		try {

			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				LOGGER.debug("Conexión establecida");
			}

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("No se ha podido establecer la conexión: ", e);

		}

	}

	public Connection getConnection() {
		return connection;
	}

	public static DataBase getInstance() throws SQLException {
		if (instance == null) {
			instance = new DataBase();
		} else if (instance.getConnection().isClosed()) {
			instance = new DataBase();
		}

		return instance;
	}

}
