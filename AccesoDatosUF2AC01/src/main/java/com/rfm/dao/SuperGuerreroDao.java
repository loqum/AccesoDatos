package com.rfm.dao;

import java.sql.SQLException;

import com.rfm.dto.SuperGuerreroDto;

public interface SuperGuerreroDao {
	
	public void createSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void updatePoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void readSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void resetPoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void deleteSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
}
