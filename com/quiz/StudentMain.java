package com.quiz;

import java.sql.SQLException;

public class StudentMain {
	
	public static void main(String[] args) throws SQLException {
		
		UpdateScore updateScore = new UpdateScore();             
		updateScore.getStudent();
		updateScore.getResult();
		updateScore.updateStudent();
		
		DisplayResult displayResult = new DisplayResult();
	    displayResult.getStudentList();

		}

}
