package com.rfm.dao;

import com.rfm.dto.SuperGuerreroDto;

import java.sql.SQLException;

public interface SuperGuerreroDao {

  public void createSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;

  public void updatePoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;

  public void readSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;

  public void resetPoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;

  public void deleteSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
}
