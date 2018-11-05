package com.rfm.dao;

import java.sql.SQLException;

import com.rfm.dto.SuperEspecieDto;

public interface SuperEspecieDao {

	public void createSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;
	public void readSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;
	public void deleteSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;

}
