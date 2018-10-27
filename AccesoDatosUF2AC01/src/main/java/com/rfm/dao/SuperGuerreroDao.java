package com.rfm.dao;

import java.sql.SQLException;

import com.rfm.dto.SuperGuerreroDto;

public interface SuperGuerreroDao {
	
	public void addSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void addPoderSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void readSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void resetSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
	public void deleteSuperGuerrero(SuperGuerreroDto superGuerrero) throws SQLException;
}
