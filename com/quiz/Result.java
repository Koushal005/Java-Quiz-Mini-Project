package com.quiz;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Result extends Student{
	
	static int score=0;
	
	public void getResult() throws SQLException {
		MapDemo mapDemo = new MapDemo();
		Set<String> set = mapDemo.getQuiz().keySet();

		Iterator<String> itr = set.iterator();                         
		System.out.println("Read the following questions carefully and Enter the answer from four options 'a','b','c','d'.");
		while (itr.hasNext()) {
			String str = itr.next();
			Map<String, String> map = mapDemo.getQuiz();
			System.out.println();
			str= str.replace("\r","\n");
			System.out.println("Q" + str);
			str= str.replace("\n","\r");
			String str1 = map.get(str);
			System.out.println("Enter your Answer >> ");
			Scanner scanner = new Scanner(System.in);
			String str2 = scanner.next();
			if(str1.equals(str2)) {
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
	

