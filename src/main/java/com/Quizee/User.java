package com.Quizee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    int roll_no;
    int score;
    String name;
    String email;


    public int getId() {
        return roll_no;
    }

    public void setRollno(int roll_no) {
        this.roll_no = roll_no;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "roll_no=" + roll_no +
                ", score=" + score +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

