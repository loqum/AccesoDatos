package com.rfm.dao;

import java.sql.SQLException;

import com.rfm.dto.SuperEspecieDto;

public interface SuperEspecieDao {

	public void addSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;
	public void deleteSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;

}
