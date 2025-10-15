package com.velocity.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Result extends Student{                                   // extends student
	
	static int score=0;                                                // variable to store score of student
	
	public void getResult() throws SQLException {
		MapDemo mapDemo = new MapDemo();                               // creating object to call method from MapDemo class
		Set<String> set = mapDemo.getQuiz().keySet();                  // calling method

		Iterator<String> itr = set.iterator();                         
		System.out.println("Read the following questions carefully and Enter the answer from four options 'a','b','c','d'.");  // message to display on console
		while (itr.hasNext()) {                                        // returns true if there is another element to read 
			String str = itr.next();
			Map<String, String> map = mapDemo.getQuiz();               // calling method
			System.out.println();
			str= str.replace("\r","\n");
			System.out.println("Q" + str);
			str= str.replace("\n","\r");
			String str1 = map.get(str);                                // display question and options
			System.out.println("Enter your Answer >> ");
			Scanner scanner = new Scanner(System.in);                  // to take input from user
			String str2 = scanner.next();                              // store answer from user into variable
			if(str1.equals(str2)) {                                    // compare answer with value of corresponding key
				 score++;                                              // if true then increase by 1
			}
		}	
			System.out.println("your score : "+score +" out of 10");   // to display score out of 10
			if(score >= 8) {                                           // if score is more than 8
				System.out.println("Remark : class A");                // remark class A
			}
			else if(score<8 && score>=6) {                             // if score is between 6 and 8
				System.out.println("Remark : class B");                // remark class B
			}
			else if(score==5) {                                        // if score is 5
				System.out.println("Remark : class c");                // remark class c
			}
			else {
				System.out.println("Remark : class D");                // if score is less than 5
				System.out.println("you are fail");                    // fail
			}
			System.out.println();
			
		}
	}
	

