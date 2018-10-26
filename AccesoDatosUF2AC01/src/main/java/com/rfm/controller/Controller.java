package com.rfm.controller;

import java.sql.SQLException;

public interface Controller {
	
	public void addSuperEspecie() throws SQLException;
	public void addSuperGuerrero() throws SQLException;
	public void addPoder() throws SQLException;
	public void readSuperGuerrero() throws SQLException;
	public void resetSuperGuerrero() throws SQLException;
	public void deleteSuperGuerrero() throws SQLException;
	public void deleteSuperEspecie() throws SQLException;

}
