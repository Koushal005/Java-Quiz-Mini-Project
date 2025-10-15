package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {              // to establish the connection with mysql
	Connection connection = null;

	//nice use of utility method here
	public Connection getConnectionDetails() {     // returns connection object
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");   // load driver class

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "redhat");   // establish connection

		} catch (Exception e) {                  // to handle exception

			e.printStackTrace();
		}

		return connection;                       // returns connection
	}

}
