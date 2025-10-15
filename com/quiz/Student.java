package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	
	int id;
	String name;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	 public void getStudent() throws SQLException {
			
			System.out.println("Enter Student Id >> ");        // student id from user
			Scanner scanner = new Scanner(System.in);
			id = scanner.nextInt();                            // store into id
			System.out.println("Enter Name >> ");              // name from user
			name = scanner.next();                             // store into name
			System.out.println();
			
			InsertData insertData = new InsertData();
			insertData.insertStudentDetails(id,name);         // pass arg to insertStudentDetails() method
			
			}

	}

