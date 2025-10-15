package com.velocity.quiz;

import java.sql.SQLException;
import java.util.List;

public class StudentMain {                                  // main class
	
	public static void main(String[] args) throws SQLException {  // main method
		
		UpdateScore updateScore = new UpdateScore();             
		updateScore.getStudent();                                  // calling method from Student class
		updateScore.getResult();                                   // calling method from Result class
		updateScore.updateStudent();                               // calling method from UpdateScore class
		
		DisplayResult displayResult = new DisplayResult();
	    displayResult.getStudentList();                            // calling method from Displa
		// yResult class
		}

}
