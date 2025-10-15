package com.velocity.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	public void insertStudentDetails(int id, String name) throws SQLException {

		try {

			ConnectionTest connectionTest = new ConnectionTest();
			connection = connectionTest.getConnectionDetails();

			preparedStatement = connection.prepareStatement("insert into student(student_id,name)values(?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);

			int i = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}
}
