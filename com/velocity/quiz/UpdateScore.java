package com.velocity.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/*
 * need to design custom exception for error message
 * try to put more efforts atleast 10-12 hours study daily
 * 
 */
public class UpdateScore extends Result {
	

	void  updateStudent() throws SQLException {
		
		try {

			ConnectionTest connectionTest = new ConnectionTest();
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
