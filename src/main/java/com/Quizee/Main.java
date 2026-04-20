package com.Quizee;


public class Main {
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.SEVERE);
        HibernateConnect hc = new HibernateConnect();
        hc.hiber();
    }
}