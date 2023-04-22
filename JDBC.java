package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "123456");
		String s = "select * from employees where salary >= 10000";
		PreparedStatement prepareStatement = c.prepareStatement(s);
		ResultSet r = prepareStatement.executeQuery();

		while (r.next()) {

			String string = r.getString("FIRST_NAME");
			System.out.print(string + " ");
			String string2 = r.getString("LAST_NAME");
			System.out.print(string2 + " ");
			String String1 = r.getString("SALARY");
			System.out.println(String1);

		}

		c.close();
	}

}
