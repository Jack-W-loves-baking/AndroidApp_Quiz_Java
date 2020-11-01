/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * This is the Bean Singleton class that takes inputs and sends it to Database
 * Connection class
 * @author Jack Wang
 */
@Singleton
public class QuestionManage {

    //Define Variables
    DatabaseConnection db = new DatabaseConnection();
    ScoreList sl = new ScoreList();
    ArrayList<ScoreList> sr;

    /**
     * This method takes inputs and sends it to the add method in Database
     * Connection class
     *
     * @param q
     * @param op3
     * @param a
     * @param op1
     * @param op4
     * @param op2
     * @throws java.lang.ClassNotFoundException
     */
    public void AddQuestion(String q, String a, String op1, String op2, String op3, String op4) throws ClassNotFoundException {
        db.addQuestion(q, a, op1, op2, op3, op4);
        System.out.println("Added");
    }

    /**
     * This method takes inputs and sends it to the Search method in Database
     * Connection class
     *
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String SearchQuestion(int id) throws ClassNotFoundException, SQLException {
        return db.SearchQuestion(id);
    }

    /**
     * This method takes inputs and sends it to the Delete method in Database
     * Connection class
     *
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void DeleteQuestion(int id) throws SQLException, ClassNotFoundException {
        db.DeleteQues(id);
    }
    
    
}
