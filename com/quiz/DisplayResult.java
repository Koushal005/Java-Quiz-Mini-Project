package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayResult {
	int a;
	int b;
	String string1;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	/*
	 * dont write method directly into class, you have to define in interface
	 * then implement it.
	 */
	public void  getStudentList() throws SQLException {
	
		try {

			Connect connectionTest = new Connect();
			connection = connectionTest.getConnectionDetails();

			preparedStatement = connection.prepareStatement("select * from student order by student_id");  // select student id,name,score from database
			ResultSet rs = preparedStatement.executeQuery();                                               // execute query

			while (rs.next()) {
				a = rs.getInt(1);                                                                          // get student id
				string1 = rs.getString(2);                                                                 // get name
				b = rs.getInt(3);                                                                          // get score
				System.out.println("id : "+a+" name : "+string1+"    score :"+b);                          // display details
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			//nice use of finally block here
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}	
	}
		
		
	
