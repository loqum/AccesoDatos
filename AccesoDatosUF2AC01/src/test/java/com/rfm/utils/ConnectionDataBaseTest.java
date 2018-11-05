package com.rfm.utils;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class ConnectionDataBaseTest {

	@Test
	public void test() {

		Connection connection = ConnectionDataBase.getInstance().getConnection();
		assertNotNull(connection);

	}

}
