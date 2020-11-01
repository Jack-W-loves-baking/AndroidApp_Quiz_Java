/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

import java.sql.SQLException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 *This is the class that takes input from the manager for Question 
 * related Queries
 * 
 * @author Jack Wang
 */
@Named
@Path("/QuestInput")
public class QuestionInput {

    @EJB
    QuestionManage qm;

    @Context
    private UriInfo context;

    static String Id = null;

    /**
     * This is the default Constructor, it is used to create a new instance of
     * the resource
     */
    public QuestionInput() {

    }

    /**
     * This is the post method that allows the manager to post Questions for the
     * client in android studio.
     *
     * @param formParams
     * @throws ClassNotFoundException
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public void addNewQuestion(
            MultivaluedMap<String, String> formParams) throws ClassNotFoundException {

        String ques = formParams.getFirst("Question");
        String ans = formParams.getFirst("Answer");
        String option1 = formParams.getFirst("opOne");
        String option2 = formParams.getFirst("opTwo");
        String option3 = formParams.getFirst("opThree");
        String option4 = formParams.getFirst("opFour");

        qm.AddQuestion(ques, ans, option1, option2, option3, option4);

    }

    /**
     * This is the post for manager, it will alow them to search up Specific
     * questions using the id
     *
     * @param m
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String SearchQuestion(MultivaluedMap<String, String> m) throws ClassNotFoundException, SQLException {

        String Id = m.getFirst("SE");
        return qm.SearchQuestion(Integer.parseInt(Id));

    }

    /**
     * This is the post method that takes ID from the manager and deletes the
     * Question for that matching id.
     *
     * @param params
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @POST
    @Path("/DEL")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String DeleteQuestion(MultivaluedMap<String, String> params) throws ClassNotFoundException, SQLException {

        Id = params.getFirst("DEL");
        qm.DeleteQuestion(Integer.parseInt(Id));
        return "Deleted Questions for ID:" + Id;

    }

    

}
