package com.rfm.dao;

import com.rfm.dto.SuperEspecieDto;

import java.sql.SQLException;

public interface SuperEspecieDao {

  public void createSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;
  
  public void readSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;
  
  public void deleteSuperEspecie(SuperEspecieDto superEspecie) throws SQLException;

}
