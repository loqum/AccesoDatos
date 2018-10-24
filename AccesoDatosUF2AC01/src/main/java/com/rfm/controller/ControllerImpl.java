package com.rfm.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.rfm.utils.DataBase;

public class ControllerImpl implements Controller {

	private static final Logger logger = Logger.getLogger(com.rfm.controller.ControllerImpl.class.getName());
	private static final String CREATE = "";

	@Override
	public void createSuperEspecie() throws SQLException {
		Connection connection = DataBase.getInstance().getConnection();
		Statement sentence = connection.createStatement();

		if (sentence.executeUpdate(CREATE) > 0) {
			logger.debug("El registro se insertó satisfactoriamente");
		} else {
			logger.error("El resgistro no se pudo insertar");
		}

		logger.debug(CREATE);
		sentence.close();
		connection.close();
	}

	@Override
	public void addSuperGuerrero() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPoder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readSuperGuerrero() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetSuperGuerrero() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSuperGuerrero() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSuperEspecie() {
		// TODO Auto-generated method stub

	}

}
