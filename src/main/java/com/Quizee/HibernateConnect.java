package com.Quizee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class HibernateConnect {
    public void hiber() {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you id: ");
        int roll_no = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your Name: ");
        String name = sc.nextLine();
        System.out.println("Enter your Email id: ");
        String email = sc.nextLine();

        user.setRollno(roll_no);
        user.setName(name);
        user.setEmail(email);


        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Question.class);
        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(user);


        System.out.println("Data saved successfully!");


        List<Question> questions = session.createQuery(
                        "FROM Question", Question.class)
                .setMaxResults(10)
                .getResultList();
        transaction.commit();
        session.close();

        Question question = new Question();
        int score = 0;

        System.out.println("Are you ready for the test(Yes/No)");
        String ipstr = sc.nextLine();
        String exstr = "Yes";
        System.out.println("*********\t Quiz Questions \t*********");
        if (ipstr.equalsIgnoreCase(exstr)) {
            for (Question q : questions) {

                System.out.println("\n Q)" + q.getQuestion_text() + "\n Enter your answer as A,B,C or D ");
                System.out.println("A)" + q.getOptionA());
                System.out.println("B)" + q.getOptionB());
                System.out.println("C)" + q.getOptionC());
                System.out.println("D)" + q.getOptionD());

                String userAnswer = String.valueOf(sc.next().toUpperCase().charAt(0));

                if (
                        userAnswer.equals(q.getCorrect_option())) {
                    score++;
                }

            }
            System.out.println("*********\t Submitted Quiz \t*********");
            System.out.println(name+ "\n  Your Final Score is: " + score + "/" + questions.size() + "\n");

            Session session2 = factory.openSession();
            Transaction tx2 = session2.beginTransaction();
            User dbUser = session2.get(User.class, roll_no); // roll_no entered by user
            dbUser.setScore(score);
            tx2.commit();
            session2.close();

            System.out.println("*********\t Thank You! \t*********");

        }
        else{
            System.out.println("User is not ready for the test");
    }
}}