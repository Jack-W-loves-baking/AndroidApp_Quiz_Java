/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class has all the GET method
 *
 * @author Jack Wang
 *
 */
@Path("/quesControl")
public class QuestionControl {

    //Define Variables
    ArrayList<QuestionList> qs, qs2;
    QuestionList quesList;
    DatabaseConnection dc = new DatabaseConnection();

    /**
     * This method returns an JSON output of the data in the database, So that
     * it can be consumed by the client.
     *
     * @return qs
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<QuestionList> getQuestions() throws SQLException, ClassNotFoundException {

        dc.createConnection();
        dc.CreateDatabaseTable();

        qs = new ArrayList<>();
        qs = dc.QuestionsData();

        return qs;

    }

    /**
     * This method get the all the data from the Questions tables for the
     * manager to see.
     *
     * @return qs2.toString()
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @GET
    @Path("/show")
    @Produces(MediaType.TEXT_PLAIN)
    public String Showdata() throws ClassNotFoundException, SQLException {
        dc.createConnection();
        dc.CreateDatabaseTable();

        qs2 = new ArrayList<>();
        qs2 = dc.QuestionsData();

        return qs2.toString();
    }
}
