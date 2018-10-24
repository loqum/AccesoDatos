package com.rfm.main;

import java.sql.SQLException;

import com.rfm.utils.DataBase;

public class Ejemplo {
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DataBase.getInstance();
		System.out.println(DataBase.getInstance().getConnection().isClosed());
    }
}
