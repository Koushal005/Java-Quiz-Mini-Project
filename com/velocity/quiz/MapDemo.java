package com.velocity.quiz;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	Connection connection = null;                                   
	PreparedStatement preparedStatement = null;

	//nice use of hashmap 
	Map<String, String> getQuiz() throws SQLException {                 // method returns map which contains que and ans as key and value

		Map<String, String> map = new HashMap<String, String>();        // creating hashmap object
		try {

			ConnectionTest connectionTest = new ConnectionTest();
			connection = connectionTest.getConnectionDetails();          // calling getconnection method

			preparedStatement = connection.prepareStatement("select questions,ans from java_quiz");   // select query
			ResultSet rs = preparedStatement.executeQuery();                                          // submit to database                               

			while (rs.next()) {
				String s = rs.getString(1);                              // store row 1 of first column into string
				String s1 = rs.getString(2);                             // store row 1 of second column into string
				map.put(s, s1);                                          // put strings into map as key and value
			}
		} catch (Exception e) {                                          // to handle exception
			e.printStackTrace();
		} finally {                                                      // to close connections 
			connection.close();
			preparedStatement.close();
		}
		return map;                                                      // return map
	}
}
