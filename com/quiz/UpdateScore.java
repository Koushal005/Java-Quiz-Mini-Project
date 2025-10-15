package com.quiz;

import java.sql.SQLException;


public class UpdateScore extends Result {
	

	void  updateStudent() throws SQLException {
		
		try {

			Connect connectionTest = new Connect();
			connection = connectionTest.getConnectionDetails();

			preparedStatement = connection.prepareStatement("update student set Score=? where student_id=?");   // update query to update score into database

			
			preparedStatement.setInt(1, score);                   
			preparedStatement.setInt(2, id);
		    int i = preparedStatement.executeUpdate();

		}

			catch (Exception e) {
			e.printStackTrace();
			}
	        finally {
		    connection.close();
		    preparedStatement.close();
               	}
		}
	
}
